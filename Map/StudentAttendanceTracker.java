import java.util.HashMap;
import java.util.Map;

public class StudentAttendanceTracker {
    public static void main(String[] args) {
        Map<String, Integer> attendance = new HashMap<>();
        
        String[] students = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for (String student : students) {
            attendance.put(student, 0);
        }
        
        String[][] dailyAttendance = {
            {"Alice", "Bob", "Charlie"},
            {"Alice", "David", "Eve"},
            {"Bob", "Charlie", "David"},
            {"Alice", "Bob", "Eve"},
            {"Charlie", "David", "Eve"},
            {"Alice", "Bob", "Charlie", "David"},
            {"Alice", "Charlie", "Eve"},
            {"Bob", "David", "Eve"},
            {"Alice", "Bob", "Charlie"},
            {"Alice", "David", "Eve"},
            {"Bob", "Charlie", "David"},
            {"Alice", "Charlie", "Eve"},
            {"Bob", "David", "Eve"},
            {"Alice", "Bob", "Charlie"},
            {"David", "Eve"}
        };
        
        for (String[] presentStudents : dailyAttendance) {
            for (String student : presentStudents) {
                attendance.put(student, attendance.get(student) + 1);
            }
        }
        
        int threshold = 10;
        System.out.println("Students with attendance below " + threshold + " days:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " days");
            }
        }
    }
}
