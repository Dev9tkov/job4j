package ru.job4j.io.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 03.01.2020
 */
public class ConsoleChat {

    private final String stopChat = "стоп";
    private final String contin = "продолжить";
    private final String end = "закончить";

    private InputStream in;
    private Answer answers;

    public ConsoleChat(String path, InputStream input) {
        this.in = input;
        this.answers = new Answer(path);
    }

    public void chat(String log) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(log)));
        String user;
        String bot;
        boolean stop = false;
        do {
            user = br.readLine();
            list.add("u: " + user);
            bw.write("u: " + user);
            bw.newLine();
            bw.flush();
            if (stopChat.equals(user)) {
                stop = true;
            } else if (contin.equals(user)) {
                stop = false;
            }
            if (!stop && !stopChat.equals(user)) {
                bot = this.answers.answer();
                list.add("b: " + bot);
                bw.write("b: " + bot);
                bw.newLine();
                bw.flush();
                System.out.println("bot: " + bot);
            }
        } while (!end.equals(user));
        br.close();
        bw.close();
    }
}
