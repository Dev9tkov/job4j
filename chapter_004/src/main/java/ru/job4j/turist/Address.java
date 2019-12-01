package ru.job4j.turist;

import java.util.Objects;

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

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartament() {
        return apartament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartament == address.apartament
                && city.equals(address.city)
                && street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartament);
    }
}
