package ru.job4j.tracker.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tracker4Test {

    @Test
    public void getInstance() {
        assertTrue(Tracker4.getInstance() == Tracker4.getInstance());
    }
}