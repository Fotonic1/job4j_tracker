package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}