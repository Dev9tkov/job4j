package ru.job4j.turist;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.11.2019
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartament;

    public Address(String city, String street, int home, int apartament) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartament = apartament;
    }
}
