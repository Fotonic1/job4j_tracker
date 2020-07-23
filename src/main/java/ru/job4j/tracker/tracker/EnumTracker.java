package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Tracker;

public enum EnumTracker {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }
}
