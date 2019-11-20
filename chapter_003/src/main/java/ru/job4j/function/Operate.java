package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 20.11.2019
 */
public class Operate {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index != end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }
}
