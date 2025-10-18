package college.main;

import college.student.Student;
import college.faculty.*;
import college.department.Department;
import static java.lang.System.out;

public class MainApp {
    public static void main(String[] args) {
        out.println("========== COLLEGE MANAGEMENT SYSTEM ==========\n");
        
        out.println("========== DEPARTMENT INFORMATION ==========");
        Department csDepartment = new Department("CS01", "Computer Science", "Dr. Michael Brown", 15);
        csDepartment.displayDepartmentInfo();
        
        out.println("\n========== FACULTY INFORMATION ==========");
        Faculty faculty1 = new Faculty(1001, "Dr. Jennifer Davis", "Computer Science", "Artificial Intelligence");
        faculty1.displayFacultyInfo();
        
        out.println();
        
        Faculty faculty2 = new Faculty(1002, "Prof. William Taylor", "Computer Science", "Database Systems");
        faculty2.displayFacultyInfo();
        
        out.println("\n========== STUDENT INFORMATION ==========");
        Student student1 = new Student(2001, "Alex Johnson", "B.Tech Computer Science", 5);
        student1.displayStudentInfo();
        
        out.println();
        
        Student student2 = new Student(2002, "Emily Davis", "B.Tech Computer Science", 3);
        student2.displayStudentInfo();
        
        out.println();
        
        Student student3 = new Student(2003, "Michael Wilson", "B.Tech Computer Science", 7);
        student3.displayStudentInfo();
        
        out.println("\n========================================");
        out.println("College Information System - Summary");
        out.println("Total Departments: 1");
        out.println("Total Faculty: 2");
        out.println("Total Students: 3");
        out.println("========================================");
    }
}
