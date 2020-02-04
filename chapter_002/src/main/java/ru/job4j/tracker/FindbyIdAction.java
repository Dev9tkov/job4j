package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindbyIdAction extends BaseAction {

    public FindbyIdAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        output.accept("Enter Id: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item != null) {
            String description = String.format("%s %s", item.getId(), item.getName());
            output.accept(description);
        } else {
            output.accept("This Id does not exist");
        }
        return true;
    }
}
