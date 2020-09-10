package ru.job4j.tracker.tracker;

import ru.job4j.tracker.MemTracker;

public class Tracker3 {
    private static final MemTracker INSTANCE = new MemTracker();

    private Tracker3() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        MemTracker tracker = Tracker3.getInstance();
    }
}
