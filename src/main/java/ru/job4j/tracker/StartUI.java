package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== all items ===");
        for (Item item:
                tracker.findAll()) {
            System.out.println(item);
        }
    }

    public static void  editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit a Item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askString("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("=== Edit completed ===");
        } else {
            System.out.println("=== Edit failed ===");
        }
    }

    public static void deleteItem(Input input,Tracker tracker) {
        System.out.println("=== Delete a Item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("=== Delete completed ===");
        } else {
            System.out.println("Delete failed");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("=== This id don't exist ===");
        }
    }

    private static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        String name = input.askString("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("=== This name don't exist ===");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
