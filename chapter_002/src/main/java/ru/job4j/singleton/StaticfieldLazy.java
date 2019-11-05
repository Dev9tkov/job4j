package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class StaticfieldLazy {
    private static StaticfieldLazy instance;

    private StaticfieldLazy() {
    }

    public static StaticfieldLazy getInstance() {
        if (instance == null) {
            instance = new StaticfieldLazy();
        }
        return instance;
    }
    public Item add(Item model) {
        return model;
    }
}
