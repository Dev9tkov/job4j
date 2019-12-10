package ru.job4j.list;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 10.12.2019
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке
     * @return
     */
    public E delete() {
        Node<E> temp = this.first;
        this.first = this.first.next;
        size--;
        return temp.data;
    }

    /**
     * Метод получения элемента по индексу.
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Хранение данных
     * @param <E>
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
