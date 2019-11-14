package ru.job4j.list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 14.11.2019
 */
public class SortUserTest {
    @Test
    public void whensort() {
        List<Usernew> user = new ArrayList<>();
        Usernew user1 = new Usernew(15, "Ivan");
        Usernew user2 = new Usernew(13, "Max");
        Usernew user3 = new Usernew(17, "Anton");
        user.add(user1);
        user.add(user2);
        user.add(user3);
        SortUser sortm = new SortUser();
        Set<Usernew> result = sortm.sort(user);
        Set<Usernew> expected = new TreeSet<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        assertThat(result, is(expected));
    }
}
