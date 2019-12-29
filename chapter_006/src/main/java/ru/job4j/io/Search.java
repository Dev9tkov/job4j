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
            for (String volume : exts) {
                if (child.getName().contains(volume)) {
                    result.add(child);
                }
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return result;
    }
}
