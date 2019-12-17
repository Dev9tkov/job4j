package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

/**
 * To do
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                name.equals(user.name) &&
                birthday.equals(user.birthday);
    }
}
