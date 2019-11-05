package ru.job4j.tracker;

public interface UserAction {
    int key();

    String info();

    boolean execute(Input input, Tracker tracker);
}
