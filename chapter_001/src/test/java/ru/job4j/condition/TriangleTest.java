package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point n = new Point(2, 6);
        Point o = new Point(0, 3);
        Point k = new Point(1, 4);

        Triangle tr = new Triangle(n, o, k);
        double rsl = tr.area();
        assertThat(rsl, is(0.5));
    }
}

