package ru.job4j.filterstream;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 28.11.2019
 */
public class CountTest {
    @Test
    public void whenListIntegerThenSum() {
        Count count = new Count();
        List<Integer> one = Arrays.asList(8, 4, 2, 3, 1, 7, 8);
        Integer result = count.filtr(one);
        assertThat(result, is(148));
    }
}
