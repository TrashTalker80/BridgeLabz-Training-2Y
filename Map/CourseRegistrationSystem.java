import java.util.HashMap;
import java.util.Map;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Map<String, Integer> courseRegistration = new HashMap<>();
        
        courseRegistration.put("CS101", 45);
        courseRegistration.put("CS102", 52);
        courseRegistration.put("MATH201", 3);
        courseRegistration.put("PHY101", 48);
        courseRegistration.put("ENG101", 30);
        
        courseRegistration.put("CS101", courseRegistration.get("CS101") + 5);
        
        String dropCourse = "MATH201";
        int dropCount = 1;
        int currentCount = courseRegistration.get(dropCourse);
        if (currentCount - dropCount >= 0) {
            courseRegistration.put(dropCourse, currentCount - dropCount);
        }
        
        System.out.println("Near Full Courses (count >= 50):");
        for (Map.Entry<String, Integer> entry : courseRegistration.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
            }
        }
        
        System.out.println("\nUnder-subscribed Courses (count < 5):");
        for (Map.Entry<String, Integer> entry : courseRegistration.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
            }
        }
    }
}
