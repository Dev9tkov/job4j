package ru.job4j.tracker;
import java.util.function.Consumer;

public class ExitAction extends BaseAction {

    public ExitAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        return false;
    }

}
