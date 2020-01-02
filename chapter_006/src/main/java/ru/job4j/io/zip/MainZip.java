package ru.job4j.io.zip;

import java.io.IOException;
import java.text.ParseException;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 31.12.2019
 */
public class MainZip {
    public static void main(String[] args) throws ParseException {
        Zip zip = new Zip();
        Args keys = new Args(args);
        try {
            zip.pack(keys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
