package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.11.2019
 */
public class UserConvertTest {
    @Test
    public void covertHashMap() {
        UserConvert convert = new UserConvert();
        User test1 = new User(1, "Max", "Moscow");
        User test2 = new User(2, "Kirill", "Perm");
        User test3 = new User(3, "Alex", "Tver'");
        List<User> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        HashMap<Integer, User> convertmap = convert.process(list);
        assertThat(convertmap.get(3).getName(), is("Alex"));
    }
}
