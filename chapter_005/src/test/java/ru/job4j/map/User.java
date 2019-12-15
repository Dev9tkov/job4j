package ru.job4j.map;

import java.util.Calendar;

/**
 * Создать модель User и три поля String name, int children, Calendar birthday
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 15.12.2019
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
