import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();
        
        grades.put("John", 85.5);
        grades.put("Alice", 92.0);
        grades.put("Bob", 78.5);
        grades.put("Charlie", 88.0);
        
        grades.put("Alice", 95.0);
        
        grades.remove("Charlie");
        
        Map<String, Double> sortedGrades = new TreeMap<>(grades);
        
        System.out.println("Student Grades (Alphabetically):");
        for (Map.Entry<String, Double> entry : sortedGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
