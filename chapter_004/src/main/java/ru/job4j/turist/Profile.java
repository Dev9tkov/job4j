package ru.job4j.turist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.11.2019
 */
public class Profile {

    private Address adress;

    public Profile(Address adress) {
        this.adress = adress;
    }

    public Address getAdress() {
        return adress;
    }
}
