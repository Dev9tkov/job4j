package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class PrivateStaticFinalClassLazy {
    private PrivateStaticFinalClassLazy() {
    }

    public static PrivateStaticFinalClassLazy getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final PrivateStaticFinalClassLazy INSTANCE = new PrivateStaticFinalClassLazy();
    }
}
