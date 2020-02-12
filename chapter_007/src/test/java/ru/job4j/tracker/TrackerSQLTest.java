package ru.job4j.tracker;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkConnection() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenAdd3ItemsThenFind3Items() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = new Item("add item1", "test1", "task1");
        Item item2 = new Item("add item2", "test2", "task2");
        Item item3 = new Item("add item3", "test3", "task3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        List<Item> expected = List.of(item1, item2, item3);
        assertThat(sql.findAll(), is(expected));
    }

    @Test
    public void whenDeleteItemThenReturnsTrue() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = new Item("delete item", "test1", "task1");
        sql.add(item1);
        boolean result = sql.delete(item1.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenReplaceItemThenFindThisItem() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = new Item("replace item1", "test", "task1");
        Item item2 = new Item("replaced item", "replace", "task1");
        sql.add(item1);
        boolean result = sql.replace(item1.getId(), item2);
        assertThat(result, is(true));
    }

    @Test
    public void whenSearchByIdItemThenReturnsItemWithThisId() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        sql.init();
        Item item1 = new Item("search item", "test1", "task1");
        sql.add(item1);
        Item result = sql.findById(item1.getId());
        assertThat(result, is(item1));
    }
}
