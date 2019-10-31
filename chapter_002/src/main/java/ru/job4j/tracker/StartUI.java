package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== all Item ====");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(tracker.findAll()[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Replace Item ====");
                System.out.print("Enter Id: ");
                String id = scanner.nextLine();
                System.out.print("Enter item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
                System.out.println("Item with Id " + id + "replace by Item " + name);
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter Id: ");
                String id = scanner.nextLine();
                System.out.println("Item deleted? - "+ tracker.delete(id));
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id: ");
                String id = scanner.nextLine();
                if (tracker.findById(id) != null) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("This Id does not exist");
                }

            } else if (select == 5) {
                System.out.println("=== Find items by Name ====");
                System.out.print("Enter key: ");
                String key = scanner.nextLine();
                for (int i = 0; i < tracker.findByName(key).length; i++) {
                    System.out.println(tracker.findByName(key)[i]);
                }

            } else if (select == 6) {
                System.out.print("=== Exit Program ====");
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu. ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
