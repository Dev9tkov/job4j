package ru.job4j.magnit;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;


/**
 * @author Ilya Devyatkov
 * @since 10.02.2020
 */
public class ParserSAXTest {
    @Test
    public void whenParse2EntryShouldSumNine() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        String LN = System.getProperty("line.separator");
        String xmlDoc = Joiner.on(LN).join(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
                "<entries>",
                "　<entry field=\"4\"/>",
                "　<entry field=\"5\"/>",
                "</entries>");
        File saxFile = Files.write(Path.of(tempDir + "testxsrt.xml"), xmlDoc.getBytes(), StandardOpenOption.CREATE).toFile();
        ParserSAX parserSAX = new ParserSAX();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        parserSAX.pars(saxFile);

        String actual = "Sum of fields = 9" + LN;
        assertThat(actual,is (output.toString()));
        saxFile.delete();
    }
}
