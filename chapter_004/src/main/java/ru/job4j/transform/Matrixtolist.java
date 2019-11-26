package ru.job4j.transform;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Нужно преобразовать числовую матрицу в список
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 26.11.2019
 */
public class Matrixtolist {
    public List<Integer> matrix (Integer[][] integers) {
        return Stream.of(integers).flatMap(Stream::of).collect(Collectors.toList());
        }
}
