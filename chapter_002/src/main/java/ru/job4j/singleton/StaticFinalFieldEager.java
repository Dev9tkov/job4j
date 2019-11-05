package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class StaticFinalFieldEager {
    private static final StaticFinalFieldEager INSTANCE = new StaticFinalFieldEager();

    private StaticFinalFieldEager() {
    }

    public static StaticFinalFieldEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
