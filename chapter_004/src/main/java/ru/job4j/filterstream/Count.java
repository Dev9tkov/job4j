package ru.job4j.filterstream;

import java.util.List;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 28.11.2019
 */
public class Count {

    public Integer filtr(List<Integer> data) {
        Integer count = data.stream()
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .reduce((v1, v2) -> v1 + v2)
                .get();
        return count;
    }
}
