package ru.job4j.tree;
import java.util.ArrayList;
import java.util.List;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 20.12.2019
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}
