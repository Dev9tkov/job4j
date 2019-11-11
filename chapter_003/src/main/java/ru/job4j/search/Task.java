package ru.job4j.search;

/**
 * 2. Очередь с приоритетом на LinkedList[#187414].
 * При добавлении нового элемента. мы должны его расположить в нужную позиции.
 * Например. У нас есть список задач на день и в какой то момент времени. мы понимаем,
 * что нам нужный выполнить более важные задачи. Мы меняем свой список так,
 * чтобы наиболее важные задачи стояли сначала
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 11.11.2019
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
