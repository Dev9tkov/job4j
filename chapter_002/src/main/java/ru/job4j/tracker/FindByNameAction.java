package ru.job4j.tracker;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name) {
        super(key, name);
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
