package ru.job4j.tree;
import java.util.Optional;


/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 21.12.2019
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent
     * Parent может иметь список child
     * @param parent
     * @param child
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    boolean isBinary();
}
