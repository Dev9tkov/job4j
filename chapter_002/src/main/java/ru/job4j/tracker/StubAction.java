package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
