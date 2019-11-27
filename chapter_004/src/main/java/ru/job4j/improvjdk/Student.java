package ru.job4j.improvjdk;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Comparator;
import java.util.Objects;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 27.11.2019
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getScope() > o2.getScope())
            return -1;
        else if(o1.getScope() < o2.getScope())
            return 1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return scope == student.scope &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }
}
