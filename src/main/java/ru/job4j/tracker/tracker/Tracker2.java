package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Tracker;

public class Tracker2 {
    private static Tracker instance;

    private Tracker2() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
