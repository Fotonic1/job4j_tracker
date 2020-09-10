package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        TreeSet<String> tmp = new TreeSet<>();
    for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += start.equals("") ? el : "/" + el;
                tmp.add(start);
            }
        }
        ArrayList<String> orgs = new ArrayList<>(tmp);
        return orgs;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
