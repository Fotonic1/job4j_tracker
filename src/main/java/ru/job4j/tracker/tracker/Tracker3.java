package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class Tracker3 {
    private static final Tracker3 INSTANCE = new Tracker3();

    private Tracker tracker = new Tracker();

    private Tracker3() {
    }

    public static Tracker3 getInstance() {
        return INSTANCE;
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

    public static void main(String[] args) {
        Tracker3 tracker = Tracker3.getInstance();
    }
}
