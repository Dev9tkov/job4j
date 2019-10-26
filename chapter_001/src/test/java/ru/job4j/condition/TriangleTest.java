package ru.job4j.condition;
import org.junit.Test;
import org.junit.Assert;
import ru.job4j.calculator.Fit;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point n = new Point(2, 6);
        Point o = new Point(0, 3);
        Point k = new Point(1, 4);
        Triangle tr = new Triangle(n, o, k);
        double expected = tr.area();
        double out = 0.5;
        Assert.assertEquals(expected, out, 0.01);
    }
}



