package ru.job4j.tracker.tracker;

import ru.job4j.tracker.MemTracker;

public enum EnumTracker {
    INSTANCE;

    private MemTracker tracker = new MemTracker();

    public MemTracker getInstance() {
        return tracker;
    }
}
