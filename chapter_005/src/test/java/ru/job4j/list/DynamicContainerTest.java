package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class DynamicContainerTest {
    @Test
    public void whenAddMoreThanCapasityThenArrayGetsBigger() {
        DynamicContainer<String> dynamic = new DynamicContainer<>();
        dynamic.add("test1");
        dynamic.add("test2");
        dynamic.add("test3");
        dynamic.add("test4");
        dynamic.add("test5");
        String result = dynamic.get(4);
        assertThat(result, is("test5"));
    }
}