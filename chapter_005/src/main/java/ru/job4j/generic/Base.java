package ru.job4j.generic;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public abstract class Base {
    private final String id;

    protected Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
