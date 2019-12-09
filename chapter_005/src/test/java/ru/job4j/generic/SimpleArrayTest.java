package ru.job4j.generic;

import org.junit.Assert;
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
public class SimpleArrayTest {

    @Test
    public void whenAddStringThenAdd() {
        SimpleArray<String> simple = new SimpleArray(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenAddIntThenAdd() {
        SimpleArray<Integer> simple = new SimpleArray(4);
        simple.add(1);
        int result = simple.get(0);
        assertThat(result, is(1));
    }
    @Test
    public void whenSetStringThenChangeArray() {
        SimpleArray<String> simple = new SimpleArray(4);
        simple.add("test1");
        simple.add("test2");
        simple.add("test3");
        simple.add("test4");
        simple.set(1, "test6");
        String result = simple.get(1);
        assertThat(result, is("test6"));
    }

    @Test
    public void whenRemoveStringThenLessSize() {
        SimpleArray<String> simple = new SimpleArray(4);
        simple.add("test1");
        simple.add("test2");
        simple.add("test3");
        simple.add("test4");
        simple.remove(1);
        String result = simple.get(1);
        assertThat(result, is("test3"));
    }
}