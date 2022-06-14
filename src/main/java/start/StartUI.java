package start;

import input.Input;
import model.entity.Item;
import model.tracker.Tracker;

import java.util.List;

public final class StartUI {

    public void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added item: " + item);
    }

    public void showItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            items.forEach(System.out::println);
        } else {
            System.out.println("The store does not contain items yet!");
        }
    }

    public void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace item ===");
        String name = input.askStr("Enter name: ");
        int id = input.askInt("Enter id: ");
        Item item = new Item(name);
        tracker.replace(item, id);
        System.out.println("Item changed successfully!");
    }

    public void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        System.out.println("Item deleted!");
    }

    public void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        System.out.println(item);
    }

    public void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        items.forEach(System.out::println);
    }

    void showMenu() {
        String[] menu = {
                "Add new item", "Show all items", "Replace item",
                "Delete item", "Find item by id", "Find item by name",
                "Exit"
        };

        System.out.println();
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + ". " + menu[i]);
        }
        System.out.println();
    }

    public void start(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int option = input.askInt("Enter an option please: ");
            switch (option) {
                case 1 -> createItem(input, tracker);
                case 2 -> showItems(tracker);
                case 3 -> replaceItem(input, tracker);
                case 4 -> deleteItem(input, tracker);
                case 5 -> findById(input, tracker);
                case 6 -> findByName(input, tracker);
                case 7 -> {
                    run = false;
                    System.out.println("Have a nice day!");
                }
                default -> System.out.println("This option does not exist! Try again!");
            }
        }
    }
}
