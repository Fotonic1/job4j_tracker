package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        HashMap<Character, Integer> sim = new HashMap<>();
        for (char ch: left.toCharArray()) {
            if (sim.containsKey(ch)) {
                sim.put(ch, sim.get(ch) + 1);
            } else {
                sim.put(ch, 1);
            }
        }
        for (char ch: right.toCharArray()) {
            if (sim.containsKey(ch)) {
                if (sim.get(ch) > 1) {
                    sim.put(ch, sim.get(ch) - 1);
                } else {
                    sim.remove(ch);
                }
            } else {
                rsl = false;
                break;
            }
        }
        return sim.isEmpty() && rsl;
    }
}
