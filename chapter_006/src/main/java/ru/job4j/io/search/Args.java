package ru.job4j.io.search;
import com.google.common.base.Joiner;
import org.apache.commons.cli.*;

/**
 * 1. Создать программу для поиска файла.
 * 2. Программа должна искать данные в заданном каталоге и подкаталогах.
 * 3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
 * 4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 * Ключи
 * -d - директория в которая начинать поиск.
 * -n - имя файл, маска, либо регулярное выражение.
 * -m - искать по маcке, либо -f - полное совпадение имени
 * -o - результат записать в файл.
 * 5. Программа должна записывать результат в файл.
 * 6. В программе должна быть валидация ключей и подсказка.
 *
 * @author Ilya Devyatkov
 * @since 13.01.2020
 */
public class Args {

    private String directory;
    private String output;
    private String fileName;
    private String[] args;

    private static final String LN = System.lineSeparator();

    /**
     * Поиск по критериям:
     * fullName - полное совпадение имени
     * mask - поиск по маске
     * regEx -регулярное выражение
     */
    private Boolean fullName;
    private Boolean mask;
    private Boolean regEx;

    public Args(String[] args) {
        this.args = args;
        if (args.length != 7) {
            help();
        }
        cmdParser();
    }

    public String getDirectory() {
        return directory;
    }

    public String getOutput() {
        return output;
    }

    public String getFileName() {
        return fileName;
    }

    public Boolean getFullName() {
        return fullName;
    }

    public Boolean getMask() {
        return mask;
    }

    public Boolean getRegEx() {
        return regEx;
    }

    public void cmdParser() {
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        options.addOption("d", "directory", true, "directory to search");
        options.addOption("n", "name file", true, "name to search");
        options.addOption("m", "mask", false, "mask search");
        options.addOption("f", "full name", false, "full name search");
        options.addOption("r", "regular expression", false, "regular expression search");
        options.addOption("o", "output", true, "output file's name");

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("d")) {
                System.out.println("We have directory Option. The value is:");
                System.out.println(cmd.getOptionValue("d"));
                String arguments = cmd.getOptionValue("d");
                this.directory = arguments;
            }
            if (cmd.hasOption("n")) {
                System.out.println("We have name file Option. The value is:");
                System.out.println(cmd.getOptionValue("n"));
                String arguments = cmd.getOptionValue("n");
                this.fileName = arguments;
            }
            if (cmd.hasOption("m")) {
                this.fullName = false;
                this.mask = true;
                this.regEx = false;
            }
            if (cmd.hasOption("f")) {
                this.fullName = true;
                this.mask = false;
                this.regEx = false;
            }
            if (cmd.hasOption("r")) {
                this.regEx = true;
                this.mask = false;
                this.fullName = false;
            }
            if (cmd.hasOption("o")) {
                System.out.println("We have output Option. The value is:");
                System.out.println(cmd.getOptionValue("o"));
                String arguments = cmd.getOptionValue("o");
                this.output = arguments;
            }
        } catch (ParseException pe) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("cmdParser", options);

        }
    }

    public void help() {
        System.out.println(
                Joiner.on(LN).join(
                        "-d - директория в которая начинать поиск",
                        "-n - имя файл, маска, либо регулярное выражение",
                        "-m - искать по макс, либо -f - полное совпадение имени, -r - регулярное выражение",
                        "-o - результат записать в файл",
                        "Пример использования: java -jar find.jar -d c:/ -n *.txt -m -o log.txt"
                )
        );
    }
}

