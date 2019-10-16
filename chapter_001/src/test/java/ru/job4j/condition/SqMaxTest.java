package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenMaxFirst() {
        int result = SqMax.max(4, 2, 3, 1);
        assertThat(result, is(4));
    }
    @Test
    public void whenMaxSecond() {
        int result = SqMax.max(4, 6, 3, 1);
        assertThat(result, is(6));
    }
    @Test
    public void whenMaxThird() {
        int result = SqMax.max(4, 6, 9, 1);
        assertThat(result, is(9));
    }
    @Test
    public void whenMaxForth() {
        int result = SqMax.max(3, 1, 2, 8);
        assertThat(result, is(8));
    }
    @Test
    public void whenMaxThird2() {
        int result = SqMax.max(4, 2, 8, 1);
        assertThat(result, is(8));
    }
}
