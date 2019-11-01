package ru.job4j.exampls;

import ru.job4j.exampls.Doctor;

public class Dentist extends Doctor {

    private String klinika;

    public Dentist(String name, String surname, String education, String birthday, int stepen, String klinika) {
        super(name, surname, education, birthday, stepen);
        this.klinika = klinika;
    }

    public String getKlinika() {
        return this.klinika;
    }

    public void treatTeeth() {
    }
}
