package ru.job4j.io;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 26.12.2019
 */
public class AnalyzeTest {
    @Before
    public void before() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("server.txt"))) {
            out.println("200 10:56:01");
            out.println("");
            out.println("200 10:57:01");
            out.println("");
            out.println("400 10:58:01");
            out.println("");
            out.println("200 10:59:01");
            out.println("");
            out.println("500 11:01:02");
            out.println("");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void whenServerdoestWork2Times() throws FileNotFoundException {
        Analyze analyze = new Analyze();
        analyze.unavailable("server.txt", "unavailable.txt");
        Scanner scanner = new Scanner(new FileInputStream("unavailable.txt"));
        assertThat(scanner.nextLine(), is("10:58:01;10:59:01"));
        assertThat(scanner.nextLine(), is("11:01:02;11:02:02"));
        scanner.close();
    }
}
