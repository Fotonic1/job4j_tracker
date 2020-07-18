package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions, out);
            int select = input.askInt("Select: ");
            run = actions[select].execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions, Output out) {
        out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        Output out = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new EditAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(new ConsoleOutput()).init(input, tracker, actions);
    }
}
