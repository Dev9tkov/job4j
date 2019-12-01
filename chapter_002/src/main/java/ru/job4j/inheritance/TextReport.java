package ru.job4j.inheritance;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 01.12.2019
 */
public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
