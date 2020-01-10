package ru.job4j.io;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 28.12.2019
 */
public class SearchTest {

    @Test
    public void whenSearchTxtAndPdfThen4Files() throws IOException {
        Search search = new Search();
        List exts = Arrays.asList(".txt", ".pdf");
        String dir = System.getProperty("java.io.tmpdir");
        File rootDir = new File(dir + "Main");
        rootDir.mkdir();
        File subDir = new File(rootDir.getPath() + "/subDir");
        subDir.mkdir();
        File first = new File(rootDir, "firstfile.txt");
        File second = new File(rootDir, "secondfile.txt");
        File third = new File(subDir, "thirdfile.pdf");
        File forth = new File(subDir, "forthfile.pdf");
        File fifth = new File(subDir, "fifthfile.doc");
        first.createNewFile();
        second.createNewFile();
        third.createNewFile();
        forth.createNewFile();
        fifth.createNewFile();
        List<File> result = search.searchFile(rootDir.getAbsolutePath(), exts);
        assertThat(result.get(0).getName(), is("firstfile.txt"));
        assertThat(result.get(1).getName(), is("secondfile.txt"));
        assertThat(result.size(), is(4));
        delfile(rootDir);
    }

    public static void delfile(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File vol : file.listFiles()) {
                    delfile(vol);
                }
            }
            file.delete();
        }
    }
}
