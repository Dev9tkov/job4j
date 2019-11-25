package ru.job4j.turist;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.11.2019
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAdress()).collect(Collectors.toList());
    }
}
