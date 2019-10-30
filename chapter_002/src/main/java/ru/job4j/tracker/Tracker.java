package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указаткль ячейки для новой заявки
     */
    private int position = 0;

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = null;
                System.arraycopy(items, 0, items, i + 1,position - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = Arrays.copyOf(items, position);
        return result;
    }

    public Item[] findByName(String key) {
        int k = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                k++;
            }
        }
        Item[] result = new Item[k];
        int j = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                result[j] = this.items[i];
                j++;
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            Item item = items[i];
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
