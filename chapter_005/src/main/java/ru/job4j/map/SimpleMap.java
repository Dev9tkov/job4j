package ru.job4j.map;

import java.util.*;


/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 19.12.2019
 */
public class SimpleMap<K, V> implements Iterable<V> {
    /**
     * начальная вместимость
     */
    private int defaultCapacity = 16;

    /**
     * Коэффицент загрузки, при котором увеличивается значение массива
     */
    private float loadFactor = 0.75f;

    /**
     * Массив для хранения пар ключ-значение
     */
    private Node<K, V>[] table;

    /**
     * Количество добавленных объектов в массив
     */
    private int size;

    /**
     * Счетчик изминений(для реализации fail fast поведения итератора)
     */
    private int modCount;

    /**
     * Конструктор со значением по умолчанию
     */
    public SimpleMap() {
        table = (Node<K, V>[]) new Node[defaultCapacity];
    }

    /**
     * Создает конструктор с указанной начальной емкостью
     * @param initialCapacity начальная емкость
     */
    public SimpleMap(int initialCapacity) {
        if (initialCapacity < 0 && initialCapacity % 2 != 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        this.resize(initialCapacity);
    }

    /**
     * Расчет хэша для ключа.
     * key.hashCode() Получаем хэш код ключа.
     * (h >>> 16) Сдвигаем старшие разряды начального хэш кода ключа вправо на 16 позиций
     * Над результатами двух верхних элементов проводим операцию XOR.
     * Результат 1 если число складываемых битов нечетно, 0 - если четно
     * (^ побитовое логическое или)
     * @param key
     * @return
     */
    private int hash(K key) {
        int h;
        int rl;
        if (key == null) {
            rl = 0;
        } else {
            h = key.hashCode();
            rl = h ^ (h >>> 16);
        }
        return rl;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Вычисляет индекс в массиве, куда положить элемент
     * @param hash результат хэш-функции нового элемента
     * @return
     */
    private int index(int hash, int length) {
        return hash & (length - 1);
    }

    /**
     * Создание нового массива заданной вместимости
     * Перемещает значения из прошлого массива, если они не null
     * @param newSize заданная вместимость
     */
    private void resize(int newSize) {
        Node<K, V>[] newTable = (Node<K, V> []) new Node[newSize];
        if (this.table != null) {
            for (Node<K, V> volume : this.table) {
                if (volume != null) {
                    int index = this.index(this.hash(volume.key), newSize);
                    newTable[index] = volume;
                }
            }
        }
        this.table = newTable;
    }

    /**
     * Добавление новой пары ключ-значение
     * Если ключ существует - переписывает значение
     * this.table.length << 1 Побитовый сдвиг. Если начальный был 16 (1000), то
     * размер нового массива станет 32(10000)
     *
     * @param key ключ
     * @param value значение
     * @return успех операции
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int index = this.index(this.hash(key), this.table.length);
        if (this.table[index] == null) {
            this.table[index] = new Node<>(key, value);
            this.size++;
            this.modCount++;
            result = true;
            if (this.size >= loadFactor * this.table.length) {
                resize(this.table.length << 1);
            }
        } else {
            if (key != null && key.equals(this.table[index].key)) {
                this.table[index] = new Node<>(key, value);
                this.modCount++;
                result = true;
            }
        }
        return result;
    }

    /**
     * Удаляет из карты объект по заданному ключу
     * @param key ключ
     * @return успех операции
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = this.index(this.hash(key), this.table.length);
        Node<K, V> node = this.table[index];
        if (node != null && key.equals(node.key)) {
            this.table[index] = null;
            this.modCount++;
            size--;
            result = true;
        }
        return result;
    }

    /**
     * Получение значения по ключу
     * @param key ключ
     * @return значение
     */
    public V get(K key) {
        int index = this.index(this.hash(key), this.table.length);
        Node<K, V> value = this.table[index];
        V result = null;
        if (value != null && Objects.equals(key, value.key)) {
            result = value.getValue();
        }
        return result;
    }

    /**
     * Определение длины массива
     * @return
     */
    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int expectedModCount = modCount;
            int index;
            int count;

            @Override
            public boolean hasNext() {
                for (int i = index; i < table.length; i++) {
                    if (table[index] != null) {
                        index = i;
                        break;
                    }
                }
                return count < size;
            }

            @Override
            public Node<K, V> next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                count++;
                return table[index++];
            }
        };
    }

    /**
     * Класс для хранения данных в виде ключ-значение
     * @param <K> ключ
     * @param <V> значение
     */
    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + '}';
        }
    }
}




