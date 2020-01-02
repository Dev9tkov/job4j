package ru.job4j.io.zip;
import org.apache.commons.cli.*;
import java.util.ArrayList;
import java.util.List;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 31.12.2019
 */
public class Args {

    private String directory;
    private String output;
    private List<String> exclude = new ArrayList<>();
    private String[] args;

    public Args(String[] args) {
        this.args = args;
        parsCmd();
    }

    public String directory() {
        return this.directory;
    }

    public String output() {
        return this.output;
    }

    public List<String> exclude() {
        return this.exclude;
    }

    /**
     * Парсер командной строки. Подлкючил библиотеку commons-cli
     * "o" короткая форма записи, "output" длинная форма
     * true - предполагается передача параметров в программу после ключа.
     * Описание данной опции
     */
    public void parsCmd() {
        Options options = new Options();
        CommandLineParser cmdParser = new DefaultParser();
        Option exclude = new Option("e", "exclude", true, "exclude extensions");
        exclude.setArgs(Option.UNLIMITED_VALUES);
        exclude.setValueSeparator(' ');
        options.addOption(exclude);
        options.addOption("d", "directory", true,"directory to archive");
        options.addOption("o", "output", true, "output archive");

        try {
            CommandLine cmd = cmdParser.parse(options, args);
            if (cmd.hasOption("e")) {
                System.out.println("We have exclude Option. The values is:");
                System.out.println(List.of(cmd.getOptionValues("e")));
                String[] arguments = cmd.getOptionValues("e");
                for (String el : arguments) {
                    this.exclude.add(el);
                }
            }
            if (cmd.hasOption("d")) {
                System.out.println("We have directory Option. The value is:");
                System.out.println(cmd.getOptionValue("d"));
                String arguments = cmd.getOptionValue("d");
                this.directory = arguments;
            }
            if (cmd.hasOption("o")) {
                System.out.println("We have output Option. The value is:");
                System.out.println(cmd.getOptionValue("o"));
                String arguments = cmd.getOptionValue("o");
                this.output = arguments;
            }

        } catch (ParseException pe) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("cmdParse", options);
        }
    }
}
