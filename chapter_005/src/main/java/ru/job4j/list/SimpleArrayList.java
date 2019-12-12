package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер на базе связанного списка
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 10.12.2019
 */
public class SimpleArrayList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount = 0;

    /**
     * Метод вставляет в начало списка данные
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int index;
            private Node<E> current = SimpleArrayList.this.first;
            private Node<E> lastReturned = null;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if(expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = current;
                current = current.next;
                index++;
                return lastReturned.data;
            }
        };
    }
}
