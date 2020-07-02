package ru.job4j.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 02.07.2020
 */
public class Store {
    private List<String> data = new ArrayList<>();

    public void add (String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
