package ru.job4j.list;

/**
 * Задан связанный список
 * Написать алгоритм определяющий, что список содержит замыкания
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 14.12.2019
 */
public class Cyclelist {

    /**
     * Определение наличия цикличности в списке
     *
     * @param first
     * @param <T>
     * @return
     */
    public <T> boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> turtle = first;
        Node<T> hare = first;
        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                result = true;
                break;
            }
        }
        return result;
    }
}

    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

