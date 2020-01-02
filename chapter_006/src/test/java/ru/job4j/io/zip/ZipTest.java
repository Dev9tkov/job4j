package ru.job4j.io.zip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 02.01.2020
 */
public class ZipTest {
    @Test
    public void whenArchiveFolderThenZipCreated() throws IOException {
        String dir = System.getProperty("java.io.tmpdir");
        File project = new File(dir + "project");
        project.mkdir();
        File subDir = new File(project.getPath() + "/subDir");
        subDir.mkdir();
        File subSubDir = new File(subDir.getPath() + "/subSubDir");
        subSubDir.mkdir();
        File first = new File(project, "firstfile.txt");
        File second = new File(project, "secondfile.djvu");
        File third = new File(subDir, "thirdfile.pdf");
        File forth = new File(subDir, "forthfile.java");
        File fifth = new File(subDir, "fifthfile.doc");
        File six = new File(subSubDir, "six.pom");
        File seven = new File(subSubDir, "seven.md");
        first.createNewFile();
        second.createNewFile();
        third.createNewFile();
        forth.createNewFile();
        fifth.createNewFile();
        six.createNewFile();
        seven.createNewFile();
        String pathZip = dir + File.separator + "testarchive.zip";
        String[] args = {
                "-d",
                project.getAbsolutePath(),
                "-o",
                pathZip,
                "-e",
                ".txt", ".java"
        };
        Args keys = new Args(args);
        Zip zip = new Zip();
        zip.pack(keys);
        ZipInputStream zin = new ZipInputStream(new FileInputStream(pathZip));
        ZipEntry entry;
        String name;
        int files = 0;
        while ((entry = zin.getNextEntry()) != null) {
            name = entry.getName();
            assertFalse(name.endsWith(".txt"));
            assertFalse(name.endsWith(".java"));
            files++;
            zin.closeEntry();
        }
        assertThat(files, is(5));
        delfile(project);
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
