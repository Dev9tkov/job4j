package ru.job4j.tracker;
import java.util.function.Consumer;


public class ReplaceAction extends BaseAction {

    public ReplaceAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            output.accept("Update Item");
        } else {
            output.accept("Error");
        }
        return true;
    }
}
