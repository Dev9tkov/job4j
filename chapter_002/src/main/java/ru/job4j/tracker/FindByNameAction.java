package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by Name ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Enter key: ");
        String key = input.askStr("");
        for (Item item : tracker.findByName(key)) {
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
