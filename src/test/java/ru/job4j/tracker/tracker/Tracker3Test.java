package ru.job4j.tracker.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tracker3Test {

    @Test
    public void getInstance() {
    assertTrue(Tracker3.getInstance() == Tracker3.getInstance());
    }
}