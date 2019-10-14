package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        int in1 = 2;
        int in2 = 2;
        int in3 = 3;
        int in4 = 4;
        double expected = 2.23;
        double out = Point.distance(in1, in2, in3, in4);
        Assert.assertEquals(expected, out, 0.01);

    }
}
