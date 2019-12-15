package ru.job4j.set;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 14.12.2019
 */
public class SimpleSetTest {
    @Test
    public void f() {
        SimpleSet<Integer> set = new SimpleSet();
        set.add(1);
        set.add(null);
        set.add(2);
        set.add(3);
        set.add(2);
        assertThat(set.size(), is(4));
    }
}