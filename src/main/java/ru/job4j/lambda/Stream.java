package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, -5, 10, -10));
        List<Integer> rsl = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
