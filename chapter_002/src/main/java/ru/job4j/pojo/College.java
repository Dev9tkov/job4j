package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Devyatkov I.P.");
        student.setGruppa("TK-08");
        student.setCreated(new Date());

        System.out.println(student.getFio() + " uchitsya v gruppe: " + student.getGruppa() + " postupil date: " + student.getCreated());

        }

}
