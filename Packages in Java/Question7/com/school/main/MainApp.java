package com.school.main;

import com.school.data.*;
import com.school.util.*;

public class MainApp {
    public static void main(String[] args) {
        Student student = new Student("Sarah Johnson", 105, 85.5, 92.0, 88.5);
        
        System.out.println(student.toString());
        
        Analyzer analyzer = new Analyzer();
        double average = analyzer.calculateAverage(student);
        String grade = analyzer.findGrade(average);
        
        System.out.println("\nAverage Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}
