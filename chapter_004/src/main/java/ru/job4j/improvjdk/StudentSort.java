package ru.job4j.improvjdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Метод должен вернуть список студентов у которых балл аттестата больше bound
 * Stream.ofNullable - сделает из элемент поток, если элемент равен null, то возвращает пустой поток
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 27.11.2019
 */
public class StudentSort {
    public List<Student> levelof(List<Student> students, int bound) {
        List<Student> result =
                students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
        return result;
    }
}
