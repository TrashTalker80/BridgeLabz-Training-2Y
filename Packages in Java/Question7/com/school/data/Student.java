package com.school.data;

public class Student {
    private String name;
    private int rollNumber;
    private double subject1Marks;
    private double subject2Marks;
    private double subject3Marks;

    public Student(String name, int rollNumber, double subject1Marks, double subject2Marks, double subject3Marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subject1Marks = subject1Marks;
        this.subject2Marks = subject2Marks;
        this.subject3Marks = subject3Marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getSubject1Marks() {
        return subject1Marks;
    }

    public double getSubject2Marks() {
        return subject2Marks;
    }

    public double getSubject3Marks() {
        return subject3Marks;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + "\n" +
               "Roll Number: " + rollNumber + "\n" +
               "Subject 1 Marks: " + subject1Marks + "\n" +
               "Subject 2 Marks: " + subject2Marks + "\n" +
               "Subject 3 Marks: " + subject3Marks;
    }
}
