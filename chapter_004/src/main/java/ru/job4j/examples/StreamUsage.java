package ru.job4j.examples;

import java.time.format.TextStyle;
import java.util.List;
import java.util.stream.Collectors;


/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 24.11.2019
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", spent=" + spent +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Tasks #2", 100),
                new Task("Bug #3", 100)
        );

        /**
         * Получаем объект типа stream, выполняем фильтрацию.
         * метод filter, который принимает лямбда выражение Predicate<Task>
         * task -> task.name.contains("Bug")
         * Полученный результат сохраняем в коллекции типа List
         */
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")).
                collect(Collectors.toList());
        bugs.forEach(System.out::println);

        /**
         * Получаем только имена задач
         */
        List<String> names = tasks.stream().map(
                task -> task.name).collect(Collectors.toList());
        names.forEach(System.out::println);

        /**
         * Посчитаем общую сумму потраченную на все задачи
         */
        long total = tasks.stream().map(
                task -> task.spent).reduce(0L, Long::sum);
        System.out.println(total);
    }
}
