package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("=== Delete completed ===");
        } else {
            out.println("Delete failed");
        }
        return true;
    }
}
