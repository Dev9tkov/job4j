package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

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
    public List<File> files(String parent, List<String> exts) {
        File root = new File(parent);
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (searchFile(child, exts)) {
                result.add(child);
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return result;
    }

    public boolean searchFile(File file, List<String> exts) {
        return exts.stream().anyMatch(f -> f.contains(exts(file)));
    }

    public String exts(File file) {
        String fileName = file.getName();
        String[] arr = fileName.split("\\.");
        return arr[arr.length - 1];
    }
}
