package ru.job4j.calculator;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class StartCalc {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Calculator calc = new Calculator();
        InteractCalc interactCalc = new InteractCalc(input, calc, System.out::println);
        interactCalc.action();
    }
}
