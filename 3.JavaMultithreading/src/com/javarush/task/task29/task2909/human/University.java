package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;
    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student target = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) target = student;
        }
        return target;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade = 0.0;
        Student target = null;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAverageGrade) maxAverageGrade = student.getAverageGrade();
        }

        for (Student student : students) {
            if (student.getAverageGrade() == maxAverageGrade) target = student;
        }
        return target;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minAverageGrade = students.get(0).getAverageGrade();
        Student target = null;
        for (int i = 1; i < students.size()-1; i++) {
            if (students.get(i).getAverageGrade() <= minAverageGrade) minAverageGrade = students.get(i).getAverageGrade();
        }

        for (Student student : students) {
            if (student.getAverageGrade() == minAverageGrade) target = student;
        }

        return target;
    }

    public void expel(Student student){
        students.remove(student);
    }
}