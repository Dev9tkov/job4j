package ru.job4j.magnit;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;


/**
 * @author Ilya Devyatkov
 * @since 10.02.2020
 */
public class ConvertXSQTTest {
    @Test
    public void whenConvertTwoEntryThenCreateXML() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        String fn = System.getProperty("file.separator");
        String ln = System.getProperty("line.separator");
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<entries>\n"
                + "    <entry>\n"
                + "        <field>1</field>\n"
                + "    </entry>\n"
                + "    <entry>\n"
                + "        <field>2</field>\n"
                + "    </entry>\n"
                + "</entries>\n";
        File source = Files.write(Path.of(tempDir + fn + "source.xml"), xmlData.getBytes(), StandardOpenOption.CREATE).toFile();
        File dest = new File(tempDir + fn + "dest.xml");
        File sheme = new File(tempDir + fn + "sheme.xslt");
        Path copied = sheme.toPath();
        Files.copy(Objects.requireNonNull(ConvertXSQT.class.getClassLoader().getResourceAsStream("scheme.xslt")), copied, StandardCopyOption.REPLACE_EXISTING);
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(source, dest, sheme);

        String actual = new String(Files.readAllBytes(Path.of(dest.getAbsolutePath())));
        System.out.println(actual);
        String exp = Joiner.on(ln).join(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
                "<entries>",
                "<entry field=\"1\"/>",
                "<entry field=\"2\"/>",
                "</entries>");
        assertThat(actual, is(exp));
        source.delete();
        dest.delete();
        sheme.delete();
    }
}
