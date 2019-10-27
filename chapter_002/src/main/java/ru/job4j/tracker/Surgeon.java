package ru.job4j.tracker;

public class Surgeon extends Doctor {

    private String view;

    public Surgeon(String name, String surname, String education, String birthday, int stepen, String view) {
        super(name, surname, education, birthday, stepen);
        this.view = view;
    }

    public String getView() {
        return this.view;
    }

    public void doOperation() {
    }
}
