package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 06.12.2019
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            private Iterator<Integer> current = it.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (current != null) {
                    result = current.hasNext();
                    while (!result && it.hasNext()) {
                        current = it.next();
                        result = current.hasNext();
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };
    }
}
