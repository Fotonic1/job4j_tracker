package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl;
        String[] lefts = left.split("\\.");
        String[] rights = right.split("\\.");
        int length = Math.min(lefts.length, rights.length);
        for (int i = 0; i < length ; i++) {
            rsl = Integer.compare(Integer.parseInt(lefts[i]), Integer.parseInt(rights[i]));
            if (rsl != 0) return rsl;
        }
        return 0;
    }
}
