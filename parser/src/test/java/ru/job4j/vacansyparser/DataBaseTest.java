package ru.job4j.vacansyparser;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ilya Devyatkov
 * @since 14.02.2020
 */
public class DataBaseTest {
    @Test
    public void checkConection() {
        DataBase dataBase = new DataBase();
        assertThat(dataBase.init(), is(true));
    }
}

