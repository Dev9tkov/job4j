package ru.job4j.tracker;
import java.util.function.Consumer;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        output.accept("Enter Id: ");
        String id = input.askStr("");
        if (tracker.delete(id)) {
            output.accept("Item deleted");
        } else {
            output.accept("Error");
        }
        return true;
    }
}
