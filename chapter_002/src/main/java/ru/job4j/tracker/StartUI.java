package ru.job4j.tracker;

public class StartUI {

    /**
     * Метод добавляет новый Итем
     *
     * @param input
     * @param tracker
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Метод переставляет Итем
     *
     * @param input
     * @param tracker
     */
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println(" === Update item ====");
        String id = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Update Item");
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Метод удаляет Итем
     *
     * @param input
     * @param tracker
     */
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        System.out.println("Enter Id: ");
        String id = input.askStr("");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Метод находит все Итемы
     *
     * @param input
     * @param tracker
     */
    public static void findAllItem(Input input, Tracker tracker) {
        System.out.println("=== all Item ====");
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * Метод находит итем по Id
     *
     * @param input
     * @param tracker
     */
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter Id: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("This Id does not exist");
        }
    }

    /**
     * Метод находит итем по Name
     *
     * @param input
     * @param tracker
     */
    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by Name ====");
        System.out.print("Enter key: ");
        String key = input.askStr("");
        Item[] result = tracker.findByName(key);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItem(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
