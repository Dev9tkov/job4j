package ru.job4j.search;

import java.util.LinkedList;

/**
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 11.11.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int min = 0;
        for(int volume = 0; volume < tasks.size(); volume++) {
            if (tasks.get(volume).getPriority() >= task.getPriority()) {
                min = volume;
                break;
            }
        }
        tasks.add(min, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
