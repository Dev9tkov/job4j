package ru.job4j.turist;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.11.2019
 */
public class ProfilesTest {
    @Test
    public void uniqeSity() {
        Profiles profiles = new Profiles();
        Address adr1 = new Address("Moscow", "Mira", 7, 14);
        Address adr2 = new Address("Ekb", "Lenina", 5, 1);
        Address adr3 = new Address("Samara", "9 Maya", 5, 3);
        Address adr4 = new Address("Novgorod", "Zelenaya", 48, 8);
        Address adr5 = new Address("Novgorod", "Zelenaya", 48, 8);
        List<Profile> prof = List.of(
                new Profile(adr1),
                new Profile(adr2),
                new Profile(adr3),
                new Profile(adr4),
                new Profile(adr5)
                );
        List<Address> result = profiles.collect(prof);
        List<Address> expexted = List.of(adr2, adr1, adr4, adr3);
        assertThat(result, is(expexted));
    }
}
