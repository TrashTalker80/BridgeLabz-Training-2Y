import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Question {
    private int id;
    private String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Q" + id + ": " + text;
    }
}

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}

public class OnlineExaminationManagement {
    private List<Question> questions;
    private Set<String> uniqueStudentIds;
    private Queue<Student> studentQueue;
    private Stack<Question> navigationStack;

    public OnlineExaminationManagement() {
        questions = new ArrayList<>();
        uniqueStudentIds = new HashSet<>();
        studentQueue = new LinkedList<>();
        navigationStack = new Stack<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void randomizeQuestions() {
        Collections.shuffle(questions);
        System.out.println("Questions randomized");
    }

    public boolean enrollStudent(Student student) {
        if (uniqueStudentIds.contains(student.getStudentId())) {
            System.out.println("Duplicate student ID: " + student.getStudentId());
            return false;
        }
        uniqueStudentIds.add(student.getStudentId());
        studentQueue.add(student);
        System.out.println("Enrolled: " + student);
        return true;
    }

    public void serveStudents() {
        System.out.println("\nServing students:");
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            System.out.println("Now testing: " + student);
        }
    }

    public void navigateQuestions() {
        System.out.println("\nQuestion navigation:");
        for (Question q : questions) {
            navigationStack.push(q);
            System.out.println("Current: " + q);
        }
        System.out.println("\nNavigating back:");
        while (!navigationStack.isEmpty()) {
            System.out.println("Previous: " + navigationStack.pop());
        }
    }

    public static void main(String[] args) {
        OnlineExaminationManagement system = new OnlineExaminationManagement();

        system.addQuestion(new Question(1, "What is Java?"));
        system.addQuestion(new Question(2, "What are collections?"));
        system.addQuestion(new Question(3, "What is OOP?"));
        system.randomizeQuestions();

        system.enrollStudent(new Student("S001", "Alice"));
        system.enrollStudent(new Student("S002", "Bob"));
        system.enrollStudent(new Student("S001", "Alice Duplicate"));

        system.serveStudents();
        system.navigateQuestions();
    }
}
