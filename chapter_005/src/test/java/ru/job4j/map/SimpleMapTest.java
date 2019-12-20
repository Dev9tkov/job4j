package ru.job4j.map;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 20.12.2019
 */
public class SimpleMapTest {
    @Test
    public void whenInsertValueAndKeyThenGetByKayValue() {
        SimpleMap<Integer, String> simple = new SimpleMap<>();
        simple.insert(0, "abc");
        assertThat(simple.get(0), is ("abc"));
    }

    @Test
    public void whenInsertTwoEqualsKeysThenKeyHaveLastValue() {
        SimpleMap<Integer, String> simple = new SimpleMap<>();
        simple.insert(0, "abc");
        simple.insert(0, "cda");
        assertThat(simple.get(0), is ("cda"));
    }

    @Test
    public void whenDeleteValueByKayThenLessSize() {
        SimpleMap<Integer, String> simple = new SimpleMap<>();
        simple.insert(0, "abc");
        simple.insert(1, "cda");
        simple.insert(2, "fga");
        simple.delete(0);
        assertThat(simple.getSize(), is (2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNotHaveNextThenNSEE() {
        SimpleMap<Integer, String> simple = new SimpleMap<>();
        simple.insert(0, "abc");
        simple.insert(1, "cda");
        simple.insert(2, "fga");
        Iterator<String> iterator = simple.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
    @Test
    public void whenHasNextThenTrue() {
        SimpleMap<Integer, String> simple = new SimpleMap<>();
        simple.insert(0, "abc");
        simple.insert(1, "cda");
        simple.insert(2, "fga");
        Iterator<String> iterator = simple.iterator();
        assertThat(iterator.hasNext(), is (true));
        assertThat(iterator.hasNext(), is (true));
    }
}