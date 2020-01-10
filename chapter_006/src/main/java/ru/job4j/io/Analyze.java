package ru.job4j.io;
import java.io.*;
import java.util.ArrayList;

/**
 * Частой задаче в программировании является задача преобразования одного файла в другой
 * Представим, что у нас есть файл регистрации событий сервера.
 * Он имеет следующий формат
 * TYPE date
 * Type - может иметь 4 значения 200, 300, 400, 500
 * Date - это время проверки 10:56:01 (формат часы:минуты:секунды)
 * Например server.log
 * 200 10:56:01
 * 200 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 *
 * Сервер не работал. если status = 400 или 500
 * Диапазон считается последовательность статусов 400 и 500
 * Например:
 * 200 10:56:01
 * 500 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 *
 * тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02
 * Начальное время - это время когда статус 400 или 500. Конечное время это когда статус меняется с 400 или 500 на 200 300.
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.12.2019
 */
public class Analyze {

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String line;
            ArrayList<String> temps = new ArrayList<>();
            while ((line = read.readLine()) != null) {
                temps.add(line);
            }
            String first = null;
            String second = null;
            for (String value : temps) {
                if (value.startsWith("400") || value.startsWith("500")) {
                    String[] start = value.split(" ");
                    first = start[1];
                }
                if (first != null && (value.startsWith("200") || value.startsWith("300"))) {
                    String[] finish = value.split(" ");
                    second = finish[1];
                    out.println(first + ";" + second);
                    first = null;
                    second = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
