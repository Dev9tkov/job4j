package ru.job4j.generic;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public interface Store<T extends Base> {
    void add(T model);
    boolean replace(String id, T model);
    boolean delete(String id);
    T findById(String id);
}
