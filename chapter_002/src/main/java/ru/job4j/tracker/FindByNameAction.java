package ru.job4j.tracker;
import java.util.function.Consumer;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("Enter key: ");
        String key = input.askStr("");
        for (Item item : tracker.findByName(key)) {
            output.accept(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
