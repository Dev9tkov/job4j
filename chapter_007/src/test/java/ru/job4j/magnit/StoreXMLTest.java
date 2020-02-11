package ru.job4j.magnit;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * @author Ilya Devyatkov
 * @since 10.02.2020
 */
public class StoreXMLTest {
    @Test
    public void whenSaveTwoEntryThenHaveXml() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        String FN = System.getProperty("file.separator");
        File actual = new File(tempDir + FN + "actual.xml");
        StoreXML storeXML = new StoreXML(actual);
        storeXML.save(List.of(new Entry(1), new Entry(2)));
        String result = new String(Files.readAllBytes(Path.of(actual.getAbsolutePath())));
        System.out.println(Path.of(actual.getAbsolutePath()));
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<entries>\n"
                + "    <entry>\n"
                + "        <field>1</field>\n"
                + "    </entry>\n"
                + "    <entry>\n"
                + "        <field>2</field>\n"
                + "    </entry>\n"
                + "</entries>\n";
        assertThat(result, is(expected));
        actual.delete();
    }
}
