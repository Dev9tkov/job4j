package ru.job4j.inheritance;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 01.12.2019
 */
public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{\n" + "   name: " + name + "\n" + "   body: " + body + "\n" + "}";
    }
}
