import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationType;

    public CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getEvaluationType() {
        return evaluationType;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T evaluationType;

    public Course(String courseName, String department, T evaluationType) {
        this.courseName = courseName;
        this.department = department;
        this.evaluationType = evaluationType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getEvaluationType() {
        return evaluationType;
    }

    @Override
    public String toString() {
        return courseName + " [" + department + "] - " + evaluationType.getEvaluationType();
    }
}

class Department {
    private String name;
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
        System.out.println("Added course: " + course);
    }

    public void displayCourses() {
        System.out.println("\nCourses in " + name + " department:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(" - " + course);
        }
    }
}

public class UniversityCourseManagement {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        System.out.println("\nAll University Courses:");
        for (Course<? extends CourseType> course : courses) {
            System.out.println(" - " + course);
        }
    }

    public static void main(String[] args) {
        Department csDepartment = new Department("Computer Science");
        csDepartment.addCourse(new Course<>("Data Structures", "CS", new ExamCourse()));
        csDepartment.addCourse(new Course<>("Software Engineering", "CS", new AssignmentCourse()));
        csDepartment.addCourse(new Course<>("AI Research", "CS", new ResearchCourse()));
        csDepartment.displayCourses();

        Department mathDepartment = new Department("Mathematics");
        mathDepartment.addCourse(new Course<>("Calculus", "Math", new ExamCourse()));
        mathDepartment.addCourse(new Course<>("Linear Algebra", "Math", new ExamCourse()));
        mathDepartment.displayCourses();

        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(new Course<>("Physics", "Science", new ExamCourse()));
        allCourses.add(new Course<>("Chemistry Lab", "Science", new AssignmentCourse()));
        allCourses.add(new Course<>("Biology Research", "Science", new ResearchCourse()));
        displayAllCourses(allCourses);
    }
}
