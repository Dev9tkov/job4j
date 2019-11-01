package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by Name ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter key: ");
        String key = input.askStr("");
        Item[] result = tracker.findByName(key);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return true;
    }
}
