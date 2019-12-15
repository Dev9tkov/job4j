package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 15.12.2019
 */
public class UserTest {
    @Test
    public void whenNotOverridingEqualsAndHash() {
        User first = new User("Misha", 2, new GregorianCalendar(1990, 1, 24));
        User second = new User("Misha", 2, new GregorianCalendar(1990, 1, 24));
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
    }
}
