package ru.job4j.split;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 24.11.2019
 */
public class Student {
    private int score;
    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }
}
