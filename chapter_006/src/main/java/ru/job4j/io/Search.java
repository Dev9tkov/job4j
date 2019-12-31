package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 *
 * String parent-путь до каталога, с которого нужно начинать
 * exts-расширения файлов, которые мы хотим получить
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 28.12.2019
 */
public class Search {
    public List<File> files(String parent, Predicate<File> predicate) {
        File root = new File(parent);
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (predicate.test(child)) {
                result.add(child);
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return result;
    }

    public List<File> searchFile(String file, List<String> exts) {
        return files(file, (f) -> {
            boolean result = false;
            for (String el : exts) {
                if (f.getName().contains(el)) {
                    result = true;
                }
            }
            return result;
        });
    }
}
