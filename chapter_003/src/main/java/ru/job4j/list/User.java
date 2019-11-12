package ru.job4j.list;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.11.2019
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
