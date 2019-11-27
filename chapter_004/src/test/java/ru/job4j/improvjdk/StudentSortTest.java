package ru.job4j.improvjdk;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 27.11.2019
 */
public class StudentSortTest {
    @Test
    public void searchStudentbigerThanBound() {
        StudentSort sort = new StudentSort();
        List<Student> students = new ArrayList<>();
        Student st1 = new Student("Ilya", 35);
        Student st2 = new Student("Max", 45);
        Student st3 = new Student("Misha", 15);
        Student st4 = new Student("Andrey", 20);
        students.add(st1);
        students.add(st2);
        students.add(null);
        students.add(st3);
        students.add(st4);
        students.add(null);
        List<Student> result = sort.levelof(students, 15);
        List<Student> expexted = List.of(
                st2,
                st1,
                st4
        );
        assertThat(result, is(expexted));
    }
}
