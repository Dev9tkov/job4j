package ru.job4j.tracker;

public class Doctor extends Profession {

    private int stepen;

    public Doctor(String name, String surname, String education, String birthday, int stepen) {
        super(name, surname, education, birthday);
        this.stepen = stepen;
    }

    public int getStepen() {
        return this.stepen;
    }

    public void diagnos() {
    }
}
