package ru.job4j.generic;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.NoSuchElementException;


/**
 * В этом задании необходимо сделать универсальную обертку над массивом
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public class SimpleArray<T> implements Iterable<T> {

    private int size;
    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Заменяет указанным элементом (model) элемент, находящийся по индексу index
     *
     * @param position
     * @param model
     */
    public void set(int position, T model) {
        if (position >= size || position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[position] = model;
    }

    /**
     * Добавляет указанный элемент (model) в первую свободную ячейку
     *
     * @param model
     */
    public void add(T model) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index] = model;
        size++;
        index++;
    }


    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть
     * на единицу влево (в середине массива не должно быть пустых ячеек)
     *
     * @param position
     */
    public void remove(int position) {
        if (position >= size || position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = position; i < size; i++) {
            if(i + 1 < size) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = null;
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу
     *
     * @param position
     */
    public T get(int position) {
        if(position >= size || position < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.array[position];
    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;
            private int count = size;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }
        };
    }
}



