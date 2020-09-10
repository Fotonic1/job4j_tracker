package ru.job4j.tracker.tracker;

import ru.job4j.tracker.MemTracker;

public class Tracker2 {
    private static MemTracker instance;

    private Tracker2() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
