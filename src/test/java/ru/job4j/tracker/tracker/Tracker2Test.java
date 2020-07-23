package ru.job4j.tracker.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tracker2Test {

    @Test
    public void getInstance() {
        assertTrue(Tracker2.getInstance() == Tracker2.getInstance());
    }
}