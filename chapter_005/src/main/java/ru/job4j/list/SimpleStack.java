package ru.job4j.list;

/**
 * Используя контейнер на базе связанного списка создать контейнер Stack
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.12.2019
 */
public class SimpleStack<T> {

    SimpleArrayList<T> list = new SimpleArrayList<>();

    /**
     *  Возвращает значение и удаляет его из коллекции
     * @return
     */
    public T poll() {
        return list.delete();
    }

    /**
     *  Помещает значение в коллекцию
     * @param value
     */
    public void push(T value) {
        list.add(value);
    }
}
