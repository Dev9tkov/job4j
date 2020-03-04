package ru.job4j.calculator;

import org.junit.Test;

import java.util.function.Consumer;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class InteractCalcTest {

    private final Consumer<String> output = System.out::println;

    @Test
    public void when2Plus3Result5() {
        Input input = new StubInput(new String[] {"2.0", "3.0", "+", "e"});
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(input, calculator, output);
        interactCalc.action();
        assertEquals(calculator.getResult(), 5.0, 0.01);
    }

    @Test
    public void when6Div3Result2() {
        Input input = new StubInput(new String[] {"6.0", "3.0", "/", "e"});
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(input, calculator, output);
        interactCalc.action();
        assertEquals(calculator.getResult(), 2.0, 0.01);
    }

    @Test
    public void when4Multiple3Result12() {
        Input input = new StubInput(new String[] {"4.0", "3.0", "*", "e"});
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(input, calculator, output);
        interactCalc.action();
        assertEquals(calculator.getResult(), 12.0, 0.01);
    }

    @Test
    public void when10Subtract3Result12() {
        Input input = new StubInput(new String[] {"10.0", "3.0", "-", "e"});
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(input, calculator, output);
        interactCalc.action();
        assertEquals(calculator.getResult(), 7.0, 0.01);
    }
}