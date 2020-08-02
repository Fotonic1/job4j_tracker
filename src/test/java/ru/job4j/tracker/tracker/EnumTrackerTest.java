package ru.job4j.tracker.tracker;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EnumTrackerTest {

    @Test
    public void enum1() {
        assertTrue(EnumTracker.INSTANCE == EnumTracker.INSTANCE);
    }

}