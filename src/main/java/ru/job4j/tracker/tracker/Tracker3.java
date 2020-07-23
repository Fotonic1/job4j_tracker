package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Tracker;

public class Tracker3 {
    private static final Tracker INSTANCE = new Tracker();

    private Tracker3() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = Tracker3.getInstance();
    }
}
