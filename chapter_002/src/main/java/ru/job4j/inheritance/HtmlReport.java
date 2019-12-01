package ru.job4j.inheritance;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 01.12.2019
 */
public class HtmlReport extends TextReport {
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>" +
                "<br/>" +
                "<span>" + body + "</span>";
    }
}
