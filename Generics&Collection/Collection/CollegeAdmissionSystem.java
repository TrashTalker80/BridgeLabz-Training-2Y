import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class StudentApp implements Comparable<StudentApp> {
    private String studentId;
    private String name;
    private int marks;

    public StudentApp(String studentId, String name, int marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentApp student = (StudentApp) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public int compareTo(StudentApp other) {
        return Integer.compare(other.marks, this.marks);
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + marks + " marks)";
    }
}

public class CollegeAdmissionSystem {
    private List<StudentApp> allApplicants;
    private Set<StudentApp> shortlisted;
    private Queue<StudentApp> interviewQueue;
    private TreeSet<StudentApp> meritList;

    public CollegeAdmissionSystem() {
        allApplicants = new ArrayList<>();
        shortlisted = new HashSet<>();
        interviewQueue = new LinkedList<>();
        meritList = new TreeSet<>();
    }

    public void acceptApplication(StudentApp student) {
        allApplicants.add(student);
        System.out.println("Application received: " + student);
    }

    public void shortlistCandidates(int minMarks) {
        System.out.println("\nShortlisting candidates with >= " + minMarks + " marks:");
        for (StudentApp student : allApplicants) {
            if (student.marks >= minMarks) {
                shortlisted.add(student);
                interviewQueue.add(student);
                System.out.println("Shortlisted: " + student);
            }
        }
    }

    public void conductInterviews() {
        System.out.println("\nConducting interviews:");
        while (!interviewQueue.isEmpty()) {
            StudentApp student = interviewQueue.poll();
            System.out.println("Interviewing: " + student);
            if (Math.random() > 0.3) {
                meritList.add(student);
            }
        }
    }

    public void displayMeritList() {
        System.out.println("\nFinal Merit List:");
        for (StudentApp student : meritList) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        CollegeAdmissionSystem system = new CollegeAdmissionSystem();

        system.acceptApplication(new StudentApp("S001", "Alice", 85));
        system.acceptApplication(new StudentApp("S002", "Bob", 70));
        system.acceptApplication(new StudentApp("S003", "Charlie", 90));
        system.acceptApplication(new StudentApp("S004", "David", 60));

        system.shortlistCandidates(75);
        system.conductInterviews();
        system.displayMeritList();
    }
}
