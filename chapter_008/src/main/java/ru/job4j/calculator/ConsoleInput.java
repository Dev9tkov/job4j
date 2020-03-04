package ru.job4j.calculator;

import java.util.Scanner;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
