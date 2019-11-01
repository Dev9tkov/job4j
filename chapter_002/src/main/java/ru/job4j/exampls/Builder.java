package ru.job4j.exampls;

public class Builder extends Engineer {
    private int categoty;

    public Builder(String name, String surname, String education, String birthday, int exp, int categoty) {
        super(name, surname, education, birthday, exp);
        this.categoty = categoty;
    }

    public int getCategoty() {
        return this.categoty;
    }

    public void buildTower() {
    }
}
