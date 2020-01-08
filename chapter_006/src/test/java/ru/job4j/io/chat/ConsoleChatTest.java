package ru.job4j.io.chat;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 05.01.2020
 */
public class ConsoleChatTest {
    @Test
    public void whenTestingAnswersFromFile() {
        String address = getClass().getClassLoader().getResource("answer.txt").getFile();
        Answer chat = new Answer(address);
        String result = chat.answer();
        List<String> answers = chat.answers();
        assertThat(answers.contains(result), is(true));
    }

    @Test
    public void whenUserWritePauseContinueAndStopThenChatStopContinueAndExit() throws IOException {
        String address = getClass().getClassLoader().getResource("answer.txt").getFile();
        File path = new File(System.getProperty("java.io.tmpdir") + File.separator + "test.txt");
        PrintWriter pw = new PrintWriter(path);
        final String ls = System.lineSeparator();
        String words = String.format("один%sдва%sстоп%sтри%sпродолжить%sзакончить", ls, ls, ls, ls, ls);
        try (ByteArrayInputStream bin = new ByteArrayInputStream(words.getBytes());
             BufferedReader file = new BufferedReader(new FileReader(path))
        ) {
            ConsoleChat chat = new ConsoleChat(address, bin);
            chat.chat(path.getAbsolutePath());
            List<String> expected = new ArrayList<>();
            file.lines().forEach(expected::add);
            assertThat(expected.size(), is(10));
        }
        path.deleteOnExit();
    }
}

