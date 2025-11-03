import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDataProcessor {
    public static void main(String[] args) {
        int[] ages = {25, 30, 22, 45, 35, 28, 50, 19, 33, 41};
        
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age);
        }
        
        int youngestAge = Collections.min(ageList);
        int oldestAge = Collections.max(ageList);
        
        System.out.println("Youngest employee age: " + youngestAge);
        System.out.println("Oldest employee age: " + oldestAge);
    }
}
