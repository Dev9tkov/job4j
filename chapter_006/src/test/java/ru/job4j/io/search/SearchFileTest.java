package ru.job4j.io.search;
import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.io.SearchTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 20.01.2020
 */
public class SearchFileTest {
    private final static String FN = System.getProperty("file.separator");
    private final static String LN = System.getProperty("line.separator");

    public void testFinder(String[] args, String expected, String logName) {
        MainSearch.main(args);
        String line;
        StringBuilder result = new StringBuilder();
        File log = new File(System.getProperty("java.io.tmpdir") + FN + logName);
        try (BufferedReader reader = new BufferedReader(new FileReader(log.getAbsolutePath()))
        ) {
            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append(LN);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(result.toString(), is(expected));
        log.deleteOnExit();
    }

    @Test
    public void whenSearchingByFullNameThenResultsAreLogged() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        String root = path + "Test";
        File source = new File(root);
        source.mkdirs();
        new File(root + FN + "dir").mkdirs();
        new File(root + FN + "dir" + FN + "test.xml").createNewFile();
        new File(root + FN + "dir" + FN + "test.txt").createNewFile();
        String logName = "log2.txt";
        String[] args = {
                "-d", root,
                "-n", "test.xml",
                "-f",
                "-o", path + logName
        };
        this.testFinder(
                args,
                Joiner.on(LN).join(
                        root + FN + "dir" + FN + "test.xml",
                        ""
                ),
                logName
        );
        SearchTest.delfile(source);
    }

    @Test
    public void whenSearchingByMaskThenResultsAreLogged() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        String root = path + "Test";
        File source = new File(root);
        source.mkdirs();
        new File(root + FN + "dir").mkdirs();
        new File(root + FN + "subdir").mkdirs();
        new File(root + FN + "subdir" + FN + "subSubDir").mkdirs();
        new File(root + FN + "file.txt").createNewFile();
        new File(root + FN + "dir" + FN + "file.txt").createNewFile();
        new File(root + FN + "subdir" + FN + "test.xml").createNewFile();
        new File(root + FN + "subdir" + FN + "subSubDir" + FN + "test.txt").createNewFile();
        String logName = "log.txt";
        String[] args = {
                "-d", root,
                "-n", "*.txt",
                "-m",
                "-o", path + logName
        };
        this.testFinder(
                args,
                Joiner.on(LN).join(
                        root + FN + "dir" + FN + "file.txt",
                        root + FN + "file.txt",
                        root + FN + "subdir" + FN + "subSubDir" + FN + "test.txt",
                        ""
                ),
                logName

        );
        SearchTest.delfile(source);
    }

    @Test
    public void whenSearchingByRegExpThenResultsAreLogged() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        String root = path + "Test";
        File source = new File(root);
        source.mkdirs();
        new File(root + FN + "dir").mkdirs();
        new File(root + FN + "subDir").mkdirs();
        new File(root + FN + "subDir" + FN + "subSubDir").mkdirs();
        new File(root + FN + "file3.txt").createNewFile();
        new File(root + FN + "dir" + FN + "file4.txt").createNewFile();
        new File(root + FN + "subDir" + FN + "test.xml").createNewFile();
        new File(root + FN + "subDir" + FN + "subSubDir" + FN + "test.txt").createNewFile();
        String logName = "log3.txt";
        String[] args = {
                "-d", root,
                "-n", "(test).*",
                "-r",
                "-o", path + logName
        };
        this.testFinder(
                args,
                Joiner.on(LN).join(
                        root,
                        root + FN + "subDir" + FN + "subSubDir" + FN + "test.txt",
                        root + FN + "subDir" + FN + "test.xml",
                        ""
                ),
                logName
        );
        SearchTest.delfile(source);
    }
}
