package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        tracker.init();
        while (run) {
            this.showMenu(actions, out);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            run = actions.get(select).execute(input, tracker);
        }
        try {
            tracker.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showMenu(List<UserAction> actions, Output out) {
        out.println("Menu.");
        int i = 0;
        for (UserAction action : actions) {
            out.println(i++ + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Store tracker = new SqlTracker();
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindAllAction(out));
        actions.add(new EditAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(new ConsoleOutput()).init(input, tracker, actions);
    }

}
