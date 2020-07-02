package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ilya Devyatkov
 * @since 02.07.2020
 */
public class SpringDIMy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.askStr("Когда закончишь курс?");
    }
}
