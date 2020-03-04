package ru.job4j.calculator;

import com.google.common.base.Joiner;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class Calculator {

    private double result;

    public void sum(double first, double second) {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public double getResult() {
        return this.result;
    }

    public String showMenu() {
        final String LN = System.lineSeparator();
        String menu = Joiner.on(LN).join(
                "Arithmetical operations: +-/*",
                "Action menu:",
                " reselect last operation: o",
                " reuse of last result: r",
                " new calculation: n",
                " exit: e",
                ""
        );
        return menu;
    }
}
