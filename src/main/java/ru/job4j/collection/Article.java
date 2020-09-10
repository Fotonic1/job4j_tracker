package ru.job4j.collection;

import java.util.HashMap;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        HashMap<String, Integer> words = new HashMap<>();
        for (String word: origin.split("\\b")) {
                words.put(word, 1);
        }
        for (String word: line.split(" ")) {
            if (!words.containsKey(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
