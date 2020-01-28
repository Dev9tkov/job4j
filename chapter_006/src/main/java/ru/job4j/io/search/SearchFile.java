package ru.job4j.io.search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ilya Devyatkov
 * @since 13.01.2020
 */
public class SearchFile {

    private Args args;
    private List<Path> paths = new ArrayList<>();

    public SearchFile(Args args) {
        this.args = args;
    }

    /**
     * Общий метод поиска. Либо по маске, либо по полному имени файла, либо по регулярному выражению
     * результат записывается в файл
     * @throws IOException
     */
    public void search() throws IOException {
        if (this.args.getMask()) {
            paths = maskSearch(this.args.getFileName());
        } else if (this.args.getFullName()) {
            paths = fullNameSearch(this.args.getFileName());
        } else if (this.args.getRegEx()) {
            paths = regExSearch(this.args.getFileName());
        }
        writeResult(this.args.getOutput());
    }

    /**
     * Обобщенный поиск файла
     * @param predicate
     * @return
     * @throws IOException
     */
    public List<Path> search(Predicate<Path> predicate) throws IOException {
        Stream<Path> files = Files.walk(Paths.get(args.getDirectory()));
        return files.filter(predicate).collect(Collectors.toList());
    }

    /**
     * Поиск файла, если задано имя файла целиком
     * @param name имя файла
     * @return лист путей
     * @throws IOException
     */
    public List<Path> fullNameSearch(String name) throws IOException {
        Predicate<Path> pr = path -> path.toString().contains(name);
        return search(pr);
    }

    /**
     * Поиск файла, если задана маска
     * @param mask маска для поиска
     * @return лист путей
     * @throws IOException
     */
    public List<Path> maskSearch(String mask) throws IOException {
        String[] value = mask.split("\\.");
        String exp = value[1];
        Predicate<Path> pr = path -> path.toString().contains(exp);
        return search(pr);
    }

    /**
     * Поиск файла, если задано регулярное выражение
     * @param regEx регулярное выражение
     * @return лист путей
     * @throws IOException
     */
    public List<Path> regExSearch(String regEx) throws IOException {
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Predicate<Path> pr = path -> pattern.matcher(path.getFileName().toString()).find();
        return search(pr);
    }

    /**
     * Запись результатов поиска в файл
     * @param path путь к файлу-логу
     */
    public void writeResult(String path) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            for (Path volume : paths) {
                bw.write(volume.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
