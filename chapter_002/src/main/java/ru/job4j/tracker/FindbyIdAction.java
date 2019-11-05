package ru.job4j.tracker;

public class FindbyIdAction extends BaseAction {

    public FindbyIdAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter Id: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("This Id does not exist");
        }
        return true;
    }
}
