package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        String[] lefts = left.split("\\.");
        String[] rights = right.split("\\.");
        rsl = Integer.compare(Integer.parseInt(lefts[0]), Integer.parseInt(rights[0]));
        return rsl;
    }
}
