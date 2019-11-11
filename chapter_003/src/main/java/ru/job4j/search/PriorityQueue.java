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
        if (tasks.isEmpty()) {
            tasks.add(0, task);
        }
        for(Task volume : tasks) {
            if (volume.getPriority() > task.getPriority()) {
            int element = tasks.indexOf(volume);
            tasks.add(element, task);
            break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
