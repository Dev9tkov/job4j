package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 14.12.2019
 */
public class CyclelistTest {

    @Test
    public void whenDontHaveCycleThenFalse() {
        Cyclelist cycl = new Cyclelist();
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(7);
        first.next = second;
        second.next = third;
        third.next = null;
        assertThat(cycl.hasCycle(first), is(false));
    }

    @Test
    public void whenHaveCycleThenTrue() {
        Cyclelist cycl = new Cyclelist();
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(7);
        first.next = second;
        second.next = third;
        third.next = second;
        assertThat(cycl.hasCycle(first), is(true));
    }
}