package ru.job4j.io.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 31.12.2019
 */
public class Zip {

    /**
     * Проверяет содержимое каталога
     * @param root адрес корневой папки
     * @param ext расширения файлов, которые включать не нужно
     * @return список файлов
     */
    public List<File> seekBy(String root, List<String> ext) {
        List<File> result = new ArrayList<>();
        File file = new File(root);
        Queue<File> parent = new LinkedList<>();
        parent.offer(file);
        while (!parent.isEmpty()) {
            File child = parent.poll();
            if (!child.isDirectory()) {
                String fileName = child.getName();
                if (fileName.contains(".")) {
                    if (!ext.contains(child.getName().substring(fileName.indexOf(".")))) {
                        result.add(child);
                    }
                }
            } else {
                for (File el : child.listFiles()) {
                    parent.offer(el);
                }
            }
        }
        return result;
    }

    /**
     * Архиватор проекта
     * @param args экземпляр класса Args, входящие параметры
     */
    public void pack(Args args) throws IOException {
        List<File> list = seekBy(args.directory(), args.exclude());
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(args.output(), false)))) {
            for (File file : list) {
                zip.putNextEntry(new ZipEntry(file.getAbsolutePath().substring(args.directory().length() + 1)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
