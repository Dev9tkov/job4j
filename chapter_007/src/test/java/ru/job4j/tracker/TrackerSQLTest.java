package ru.job4j.tracker;
import org.junit.Test;

import java.util.List;

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
        Item item1 = new Item("test1", "task1");
        Item item2 = new Item("test2", "task2");
        Item item3 = new Item("test3", "task3");
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
        Item item1 = new Item("test1", "task1");
        sql.add(item1);
        boolean result = sql.delete(item1.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenReplaceItemThenFindThisItem() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item item1 = new Item("test", "task1");
        Item item2 = new Item("replace", "task1");
        sql.add(item1);
        boolean result = sql.replace(item1.getId(), item2);
        assertThat(result, is(true));
    }

    @Test
    public void whenSearchByIdItemThenReturnsItemWithThisId() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item item1 = new Item("test1", "task1");
        sql.add(item1);
        Item result = sql.findById(item1.getId());
        assertThat(result, is(item1));
    }
}
