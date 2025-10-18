import college.student.Student;
import college.faculty.Faculty;

public class CollegeMain {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 101);
        student.displayStudentDetails();
        
        System.out.println();
        
        Faculty faculty = new Faculty("Dr. Smith", "Computer Science");
        faculty.displayFacultyDetails();
    }
}
