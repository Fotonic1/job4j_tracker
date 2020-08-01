package ru.job4j.tracker;

import ru.job4j.bank.User;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && id == item.id;
    }
}