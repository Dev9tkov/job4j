package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

public class StartUI {

    public void init(Input input, ITracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            Consumer<String> output = System.out::println;
            run = action.execute(input, tracker, output);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
            System.out.println("Menu.");
            for (UserAction value : actions) {
                System.out.println(value.info());
            }
        }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        ITracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(0, "Create Item"));
        actions.add(new FindAllAction(1, "Show all Items"));
        actions.add(new ReplaceAction(2, "Replace Item"));
        actions.add(new DeleteAction(3, "Delete Item"));
        actions.add(new FindbyIdAction(4, "Find Item by ID"));
        actions.add(new FindByNameAction(5, "Find Items by name"));
        actions.add(new ExitAction(6, "Exit"));
        new StartUI().init(validate, tracker, actions);
    }
}
