package ru.job4j.tracker;
import java.util.function.Consumer;


public class StubAction implements UserAction {

    private boolean call = false;

    @Override
    public int key() {
        return this.key();
    }

    @Override
    public String info() {
        return "Stub info";
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
