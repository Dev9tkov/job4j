package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 03.01.2020
 */
public class Answer {
    private File source;
    private List<String> storage;

    public Answer(String path) {
        this.source = new File(path);
        this.storage = answers();
    }

    /**
     * Копирует ответы из файла и добавляет в спиок
     * @return
     */
    public List<String> answers() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            br.lines().forEach(list :: add);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    /**
     * Возвращает случайный ответ из списка ответов
     * @return
     */
    public String answer() {
        return storage.get((new Random().nextInt(storage.size())));
    }
}
