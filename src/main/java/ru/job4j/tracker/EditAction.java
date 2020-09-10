package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("=== Edit completed ===");
        } else {
            out.println("=== Edit failed ===");
        }
        return true;
    }
}
