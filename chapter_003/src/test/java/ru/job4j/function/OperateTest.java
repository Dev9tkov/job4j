package ru.job4j.function;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 20.11.2019
 */
public class OperateTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Operate operate = new Operate();
        List<Double> result = operate.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenKvadratFunctionThenKvadratResults() {
        Operate operate = new Operate();
        List<Double> result = operate.diapason(2, 5, x -> 2 * Math.pow(2, x) + 2 * x + 1);
        List<Double> expected = Arrays.asList(13D, 23D, 41D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        Operate operate = new Operate();
        List<Double> result = operate.diapason(2, 5, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0.6931471805599453, 1.0986122886681098, 1.3862943611198906);
        assertThat(result, is(expected));
    }
}
