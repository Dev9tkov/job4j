package ru.job4j.list;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 13.11.2019
 */
public class Usernew implements Comparable<Usernew> {

    private Integer age;
    private String name;

    public Usernew(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Usernew user) {
        return this.age.compareTo(user.age);
    }
}
