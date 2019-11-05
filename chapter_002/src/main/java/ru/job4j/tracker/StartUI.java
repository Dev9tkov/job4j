package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0, "Create Item"),
                new FindAllAction(1, "Show all Items"),
                new ReplaceAction(2, "Replace Item"),
                new DeleteAction(3, "Delete Item"),
                new FindbyIdAction(4, "Find Item by ID"),
                new FindByNameAction(5, "Find Items by name"),
                new ExitAction(6, "Exit")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
