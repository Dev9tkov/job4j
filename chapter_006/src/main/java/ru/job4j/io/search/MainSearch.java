package ru.job4j.io.search;

import java.io.IOException;

/**
 * Точка входа приложения
 * @author Ilya Devyatkov
 * @since 13.01.2020
 */
public class MainSearch {
    public static void main(String[] args) {
        Args keys = new Args(args);
        SearchFile searchFile = new SearchFile(keys);
        try {
            searchFile.search();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
