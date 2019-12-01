package ru.job4j.split;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 25.11.2019
 */
public class SchoolTest {
    @Test
    public void whenBiggerThanZeroThenC() {
        School school = new School();
        Student st1 = new Student(45);
        Student st2 = new Student(60);
        Student st3 = new Student(34);
        Student st4 = new Student(72);
        Student st5 = new Student(25);
        List<Student> student = new ArrayList<>();
        student.add(st1);
        student.add(st2);
        student.add(st3);
        student.add(st4);
        student.add(st5);
        List<Student> result = school.collect(student, student1 -> student1.getScore() > 0 && student1.getScore() < 50);
        List<Student> expected = new ArrayList<>();
        expected.add(st1);
        expected.add(st3);
        expected.add(st5);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBiggerThanFiftyTheB() {
        School school = new School();
        Student st1 = new Student(50);
        Student st2 = new Student(60);
        Student st3 = new Student(34);
        Student st4 = new Student(72);
        Student st5 = new Student(25);
        List<Student> student = new ArrayList<>();
        student.add(st1);
        student.add(st2);
        student.add(st3);
        student.add(st4);
        student.add(st5);
        List<Student> result = school.collect(student, student1 -> student1.getScore() >= 50 && student1.getScore() < 70);
        List<Student> expected = new ArrayList<>();
        expected.add(st1);
        expected.add(st2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBiggerThanSeventyTheA() {
        School school = new School();
        Student st1 = new Student(50);
        Student st2 = new Student(60);
        Student st3 = new Student(34);
        Student st4 = new Student(72);
        Student st5 = new Student(25);
        List<Student> student = new ArrayList<>();
        student.add(st1);
        student.add(st2);
        student.add(st3);
        student.add(st4);
        student.add(st5);
        List<Student> result = school.collect(student, student1 -> student1.getScore() >= 70 && student1.getScore() <= 100);
        List<Student> expected = new ArrayList<>();
        expected.add(st4);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListStudentMapStudent() {
        School school = new School();
        Student st1 = new Student(50, "Ivanov");
        Student st2 = new Student(60, "Sidorov");
        Student st3 = new Student(34, "Petrov");
        List<Student> student = new ArrayList<>();
        student.add(st1);
        student.add(st2);
        student.add(st3);
        Map<String, Student> result = school.collecttoMap(student);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", st1);
        expected.put("Sidorov", st2);
        expected.put("Petrov", st3);
        assertThat(result, is(expected));
    }
}
