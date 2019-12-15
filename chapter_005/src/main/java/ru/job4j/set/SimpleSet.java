package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Реализовать коллекцию
 * Коллекция не должна хранить дубликаты
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 14.12.2019
 */
public class SimpleSet<E> implements Iterable<E> {

    private SimpleArrayList<E> list = new SimpleArrayList<>();

    /**
     * Добавление нового элемента
     * @param value
     */
    public void add(E value) {
        if (!dublicate(value)) {
            list.add(value);
        }
    }

    /**
     * Првоерка на наличие дубликатов
     * @param value
     * @return
     */
    public boolean dublicate(E value) {
        boolean result = false;
        for (E model : list) {
            if (model != null && model.equals(value) || model == null && value == null) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Вспомогательный метод для теста
     * @return
     */
    public int size() {
        return this.list.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
