package ru.job4j.tracker;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Enter Id: ");
        String id = input.askStr("");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
