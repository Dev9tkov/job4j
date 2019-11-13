package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteIdThenReturnTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        boolean result = tracker.delete(first.getId());
        assertThat(result, is(true));
    }

    @Test
    public void whenFindAllThenReturnItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenFindByNameThenReturnName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        Item fourth = new Item("test2");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        List<Item> result = tracker.findByName("test2");
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenFindByIdThenReturnName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test3");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findById(third.getId()).getName(), is("test3"));
    }
}
