package ru.job4j.di;


import ru.job4j.tracker.ConsoleInput;

/**
 * @author Ilya Devyatkov
 * @since 02.07.2020
 */
public class StartUI {

    private Store store;

    private ConsoleInput input;

//    public StartUI(Store store) {
//        this.store = store;
//    }


    public StartUI(ConsoleInput input) {
        this.input = input;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for(String value : store.getAll()) {
            System.out.println(value);
        }
    }

    public void askStr(String question) {
       input.askStr(question);
    }
}
