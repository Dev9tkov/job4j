package ru.job4j.tracker;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenAdd3ItemsThenFind3Items() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Random rm = new Random();
        String id1 = String.valueOf(rm.nextLong() + System.currentTimeMillis());
        String id2 = String.valueOf(rm.nextLong() + System.currentTimeMillis());
        String id3 = String.valueOf(rm.nextLong() + System.currentTimeMillis());
        Item item1 = new Item(id1, "test1", "task1");
        Item item2 = new Item(id2, "test2", "task2");
        Item item3 = new Item(id3, "test3", "task3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        List<Item> expected = List.of(item1, item2, item3);
        assertThat(sql.findAll(), is(expected));
    }

    @Test
    public void whenDeleteItemThenReturnsTrue() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Random rm = new Random();
        String id1 = String.valueOf(rm.nextLong() + System.currentTimeMillis());
        Item item1 = new Item(id1, "test1", "task1");
        String keyId = item1.getId();
        sql.add(item1);
        boolean result = sql.delete(keyId);
        assertThat(result, is(true));
    }

    @Test
    public void whenSearchByIdItemThenReturnsItemWithThisId() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Random rm = new Random();
        String id1 = String.valueOf(rm.nextLong() + System.currentTimeMillis());
        Item item1 = new Item(id1, "test1", "task1");
        sql.add(item1);
        String keyId = item1.getId();
        Item result = sql.findById(keyId);
        assertThat(result, is(item1));
    }
}
