package ru.job4j.generic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public class AbstractStoreTest {

    @Test
    public void whenAddUser() {
        UserStore userStore = new UserStore(3);
        User test1 = new User("test1");
        User test2 = new User("test2");
        User test3 = new User("test3");
        userStore.add(test1);
        userStore.add(test2);
        userStore.add(test3);
        User result = userStore.findById("test1");
        assertThat(result, is(test1));
    }
    @Test
    public void whenDeleteUser() {
        UserStore userStore = new UserStore(3);
        User test1 = new User("test1");
        User test2 = new User("test2");
        User test3 = new User("test3");
        userStore.add(test1);
        userStore.add(test2);
        userStore.add(test3);
        boolean expected = true;
        assertThat(userStore.delete("test1"), is(expected));
    }

    @Test
    public void whenReplaceUser() {
        UserStore userStore = new UserStore(4);
        User test1 = new User("test1");
        User test2 = new User("test2");
        User test3 = new User("test3");
        User test4 = new User("test4");
        userStore.add(test1);
        userStore.add(test2);
        userStore.add(test3);
        userStore.replace("test2", test4);
        User result = userStore.findById("test4");
        assertThat(result, is(test4));
    }
}
