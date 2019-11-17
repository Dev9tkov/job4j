package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {

    @Test
    public void whenFindName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        Item test3 = new Item("test1");
        Item test4 = new Item("test3");
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        tracker.findByName("test1");
        FindByNameAction act = new FindByNameAction(5, "test1");
        act.execute(new StubInput(new String[] {"test1", "test3"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Enter key: ")
                .add(test1.getId() + " " + test1.getName())
                .add(test3.getId() + " " + test3.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
