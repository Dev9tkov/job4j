package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenA1B2Then5() {
        Point a = new Point(4, -5);
        Point b = new Point(7, -1);
        double result = a.distance(b);
        assertThat(result, is(5.0));
    }

    @Test
    public void whena1b2c3then5() {
        Point a = new Point(0, -3, 3);
        Point b = new Point(3, 1, 3);
        double result = a.distance(b);
        assertThat(result, is(5.0));
    }

}
