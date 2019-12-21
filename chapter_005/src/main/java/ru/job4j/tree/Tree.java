package ru.job4j.tree;

import java.util.*;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 21.12.2019
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable<E> {

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> node = findBy(parent);
            if (node.isPresent()) {
                node.get().add(new Node<>(child));
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Queue<Node<E>> el = new LinkedList<>(List.of(Tree.this.root));
            @Override
            public boolean hasNext() {
                return !el.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> node = this.el.remove();
                el.addAll(node.leves());
                return node.getValue();
            }
        };
    }
}
