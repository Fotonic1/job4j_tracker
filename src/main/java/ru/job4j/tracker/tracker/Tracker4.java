package ru.job4j.tracker.tracker;

import ru.job4j.tracker.Tracker;

public class Tracker4 {

    private Tracker4() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = Tracker4.getInstance();
    }
}
