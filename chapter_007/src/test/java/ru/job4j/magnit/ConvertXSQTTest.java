package ru.job4j.magnit;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.File;
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
        String FN = System.getProperty("file.separator");
        String LN = System.getProperty("line.separator");
        String xmlData = Joiner.on(LN).join(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",
                "<entries>",
                "    <entry>",
                "        <field>1</field>",
                "    </entry>",
                "    <entry>",
                "        <field>2</field>",
                "    </entry>",
                "</entries>"
        );
        File source = Files.write(Path.of(tempDir + "source.xml"), xmlData.getBytes(), StandardOpenOption.CREATE).toFile();
        File dest = new File(tempDir + FN + "dest.xml");
        File sheme = new File(tempDir + FN + "sheme.xslt");
        Path copied = sheme.toPath();
        Files.copy(Objects.requireNonNull(ConvertXSQT.class.getClassLoader().getResourceAsStream("scheme.xslt")), copied, StandardCopyOption.REPLACE_EXISTING);
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(source, dest, sheme);

        String actual = new String(Files.readAllBytes(Path.of(dest.getAbsolutePath())));
        String exp = Joiner.on(LN).join(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
                "<entries>",
                "　<entry field=\"1\"/>",
                "　<entry field=\"2\"/>",
                "</entries>");
        assertThat(actual, is(exp));
        source.delete();
        dest.delete();
        sheme.delete();
    }
}
