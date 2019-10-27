package ru.job4j.tracker;

public class Engineer extends Profession {

    private int exp;

    public Engineer(String name, String surname, String education, String birthday, int exp) {
        super(name, surname, education, birthday);
        this.exp = exp;
    }

    public int getExp() {
        return this.exp;
    }

    public void doProect() {
    }

}
