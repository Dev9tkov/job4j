package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== All Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return true;
    }
}
