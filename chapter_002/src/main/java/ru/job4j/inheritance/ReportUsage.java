package ru.job4j.inheritance;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 01.12.2019
 */
public class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
