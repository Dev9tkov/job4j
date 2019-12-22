package ru.job4j.stat;
import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 22.12.2019
 */
public class AnalizeTest {
    @Test
    public void whenAdded2Changed2Deleted1ThenInfo221() {
        Analize info = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Max"),
                new Analize.User(3, "Petr"),
                new Analize.User(4, "Ilya")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "Kolya"),
                new Analize.User(2, "Misha"),
                new Analize.User(4, "Ilya"),
                new Analize.User(5, "Roman"),
                new Analize.User(6, "Dima")
        );
        Analize.Info data = info.diff(previous, current);
        assertThat(data.getAdded(), is(2));
        assertThat(data.getChanged(), is(2));
        assertThat(data.getDeleted(), is(1));
    }
}
