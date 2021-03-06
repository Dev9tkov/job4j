package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

public class Tracker implements ITracker {

    /**
     * Итемы будем хранить в arraylist
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    @Override
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (Item value : items) {
            if (value.getId().equals(id)) {
                items.remove(value);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public ArrayList<Item> findAll() {
        return this.items;
    }

    @Override
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item value : items) {
            if (value != null && value.getName().equals(key)) {
                result.add(value);
            }
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        for (Item value : items) {
            if (value != null && value.getId().equals(id)) {
                result = value;
                break;
            }
        }
        return result;
    }
}
