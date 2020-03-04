package ru.job4j.calculator;

import java.util.function.Consumer;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class InteractCalc {
    /**
     * Получение данных
     */
    private Input input;

    /**
     * Получение данных
     */
    private Calculator calculator;

    /**
     * Последний результат. Предыдущее вычисление
     */
    private Double lastResult;

    /**
     * Вывод данных
     */
    private Consumer<String> output;

    /**
     * Переиспользование пред. вычисления
     */
    private boolean reUse = false;

    /**
     * Повторный выбор операции
     */
    private boolean reSelect = false;

    /**
     * Предыдущая операция
     */
    private String lastOperate;

    /**
     * Конструктор
     * @param input
     * @param calculator
     * @param output
     */
    public InteractCalc(Input input, Calculator calculator, Consumer<String> output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    public void action() {
        output.accept(this.calculator.showMenu());
        boolean exit = false;
        do {
            String first, second, operation;
            if (reUse || reSelect) {
                first = String.valueOf(lastResult);
            } else {
                first = input.askStr("Enter first arg please: ");
            }
            second = input.askStr("Enter second arg please: ");
            if (reSelect) {
                operation = lastOperate;
            } else {
                operation = input.askStr("Enter operation please: ");
            }
            if (operation.equals("+")) {
                this.calculator.sum(Double.parseDouble(first), Double.parseDouble(second));
            } else if(operation.equals("-")) {
                this.calculator.subtract(Double.parseDouble(first), Double.parseDouble(second));
            } else if(operation.equals("*")) {
                this.calculator.multiple(Double.parseDouble(first), Double.parseDouble(second));
            } else if(operation.equals("/")) {
                this.calculator.div(Double.parseDouble(first), Double.parseDouble(second));
            }
            Double result = calculator.getResult();
            output.accept("Result: " + result.toString());

            String option = input.askStr("Choose next action: ");
            if (option.equals("r")) {
                lastResult = result;
                reUse = true;
                reSelect = false;
            } else if (option.equals("o")) {
                lastResult = result;
                lastOperate = operation;
                reSelect = true;
                reUse = false;
            } else if (option.equals("n")) {
                reSelect = false;
                reUse = false;
            } else if (option.equals("e")) {
                exit = true;
            }
        } while (!exit);
    }
}
