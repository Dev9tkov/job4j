package ru.job4j.split;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Поделить учеников на группы
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 24.11.2019
 */
public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().
                filter(predict).
                collect(Collectors.toList());
        return result;
    }
}
