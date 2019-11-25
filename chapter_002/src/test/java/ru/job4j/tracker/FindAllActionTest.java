package ru.job4j.tracker;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindAllActionTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Consumer<String> output = System.out::println;
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindAllAction act = new FindAllAction(1, "fix bug");
        act.execute(new StubInput(new String[] {}), tracker, output);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.getId() + " " + item.getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
