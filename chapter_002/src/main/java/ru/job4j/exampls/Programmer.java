package ru.job4j.exampls;

import ru.job4j.exampls.Engineer;

public class Programmer extends Engineer {
    private String stek;

    public Programmer(String name, String surname, String education, String birthday, int exp, String stek) {
        super(name, surname, education, birthday, exp);
        this.stek = stek;
    }
    public String getStek() {
        return this.stek;
    }

    public void writeProg() {
    }
}
