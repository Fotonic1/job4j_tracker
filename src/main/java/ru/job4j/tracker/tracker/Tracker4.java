package ru.job4j.tracker.tracker;

import ru.job4j.tracker.MemTracker;

public class Tracker4 {

    private Tracker4() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

    public static void main(String[] args) {
        MemTracker tracker = Tracker4.getInstance();
    }
}
