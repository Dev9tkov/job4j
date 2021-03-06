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
        Usernew user1 = new Usernew(15, "Ivan");
        Usernew user2 = new Usernew(13, "Max");
        Usernew user3 = new Usernew(17, "Anton");
        List<Usernew> user = List.of(
                user1,
                user2,
                user3
        );
        SortUser sortm = new SortUser();
        Set<Usernew> result = sortm.sort(user);
        Set<Usernew> expected = Set.of(
                user1,
                user2,
                user3
        );
        assertThat(result, is(expected));
    }
    @Test
    public void sortNamehTest() {
        Usernew user1 = new Usernew(15, "Max");
        Usernew user2 = new Usernew(17, "Anton");
        Usernew user3 = new Usernew(14, "Inokentii");
        List<Usernew> users = new ArrayList<>(3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        SortUser sort = new SortUser();
        List<Usernew> result = sort.sortNameLength(users);
        List<Usernew> expected = List.of(
                user1,
                user2,
                user3
        );
        assertThat(result, is(expected));
    }
    @Test
    public void sortByAllFieldsTest() {
        Usernew user1 = new Usernew(15, "Илья");
        Usernew user2 = new Usernew(17, "Артем");
        Usernew user3 = new Usernew(14, "Максим");
        Usernew user4 = new Usernew(21, "Слава");
        List<Usernew> users = new ArrayList<>(3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        SortUser sort = new SortUser();
        List<Usernew> result = sort.sortByAllFields(users);
        List<Usernew> expected = List.of(
                user2,
                user1,
                user3,
                user4
        );
        assertThat(result, is(expected));
    }
}
