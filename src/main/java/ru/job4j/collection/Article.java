package ru.job4j.collection;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        List<String> words = Arrays.stream(line.split(" ")).distinct().collect(Collectors.toList());
        for (String word:
                words) {
            rsl = origin.contains(word) && rsl;
        }
        return rsl;
    }
}
