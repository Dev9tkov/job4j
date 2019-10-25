package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max n = new Max();
        Max k = new Max();
        Max l = new Max();
        int resultn = n.max(1, 4);
        int resultk = k.max(1, 4, 18);
        int resultl = l.max(15, 21, 18, 14);
        assertThat(resultn, is(4));
        assertThat(resultk, is(18));
        assertThat(resultl, is(21));
    }
}


