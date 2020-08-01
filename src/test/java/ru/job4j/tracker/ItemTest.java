package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortUpById() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b")
        );
        items.get(0).setId(3);
        items.get(1).setId(1);
        items.get(2).setId(2);
        List<Item> expected = Arrays.asList(
                new Item("c"),
                new Item("b"),
                new Item("a")
        );
        expected.get(0).setId(1);
        expected.get(1).setId(2);
        expected.get(2).setId(3);
        Collections.sort(items);
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortDownById() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b")
        );
        items.get(0).setId(3);
        items.get(1).setId(1);
        items.get(2).setId(2);
        List<Item> expected = Arrays.asList(
                new Item("a"),
                new Item("b"),
                new Item("c")
        );
        expected.get(0).setId(3);
        expected.get(1).setId(2);
        expected.get(2).setId(1);
        Collections.sort(items, new SortDownById());
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortUpByName() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b")
        );
        List<Item> expected = Arrays.asList(
                new Item("a"),
                new Item("b"),
                new Item("c")
        );
        Collections.sort(items, new SortUpByName());
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortDownByName() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b")
        );
        List<Item> expected = Arrays.asList(
                new Item("c"),
                new Item("b"),
                new Item("a")
        );
        Collections.sort(items, new SortDownByName());
        assertThat(items, is(expected));
    }
}