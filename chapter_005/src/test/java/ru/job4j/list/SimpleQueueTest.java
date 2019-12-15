package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.12.2019
 */
public class SimpleQueueTest {

    @Test
    public void poll() {
        SimpleQueue<Integer> simple = new SimpleQueue<>();
        simple.push(1);
        simple.push(2);
        simple.push(3);
        simple.poll();
        simple.push(1);
        assertThat(simple.poll(), is(2));
        assertThat(simple.size(), is(2));
    }
}