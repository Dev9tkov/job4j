package ru.job4j.di;

/**
 * @author Ilya Devyatkov
 * @since 02.07.2020
 */
public class MainExample {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
