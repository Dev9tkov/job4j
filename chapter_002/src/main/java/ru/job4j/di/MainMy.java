package ru.job4j.di;

import ru.job4j.tracker.ConsoleInput;

/**
 * @author Ilya Devyatkov
 * @since 02.07.2020
 */
public class MainMy {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);
        ui.askStr("Когда закончишь курс?");
    }
}
