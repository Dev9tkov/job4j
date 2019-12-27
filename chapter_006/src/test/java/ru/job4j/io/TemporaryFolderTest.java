package ru.job4j.io;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @Rule позволяет создавать файлы и папки, которые нужно удалить после тестирования
 * (независимо успешно оно пройдено или нет)
 *
 * Класс TemporaryFolder используется для создания и удаления временных папок
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 27.12.2019
 */
public class TemporaryFolderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void whenCreateFileThenFileExist() throws IOException {
        File file = tempFolder.newFile("test.txt");
        assertTrue(file.exists());
    }

    @Test
    public void whenCreateFileAndDeleteThemThenFileDoesntExist() throws IOException {
        File file = tempFolder.newFile("test.txt");
        file.delete();
        assertFalse(file.exists());
    }

    @Test
    public void whenCreateFolderThenFolderExist() throws IOException {
        File file = tempFolder.newFolder("testfolder");
        assertTrue(file.exists());
    }

    @Test
    public void whenCreateFolderAndDeleteThemThenFolderDoesntExist() throws IOException {
        File file = tempFolder.newFolder("testfolder");
        file.delete();
        assertFalse(file.exists());
    }
}
