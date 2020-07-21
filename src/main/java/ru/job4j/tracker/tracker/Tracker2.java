package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class Tracker2 {
    private static Tracker2 instance;
    private Tracker tracker = new Tracker();

    private Tracker2() {
    }

    public static Tracker2 getInstance() {
        if (instance == null) {
            instance = new Tracker2();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
