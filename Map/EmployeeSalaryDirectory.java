import java.util.HashMap;
import java.util.Map;

public class EmployeeSalaryDirectory {
    public static void main(String[] args) {
        Map<String, Double> salaries = new HashMap<>();
        
        salaries.put("John", 50000.0);
        salaries.put("Alice", 60000.0);
        salaries.put("Bob", 55000.0);
        salaries.put("Charlie", 70000.0);
        salaries.put("David", 65000.0);
        salaries.put("Eve", 58000.0);
        
        String employeeForRaise = "John";
        double raisePercentage = 10.0;
        if (salaries.containsKey(employeeForRaise)) {
            double currentSalary = salaries.get(employeeForRaise);
            double newSalary = currentSalary + (currentSalary * raisePercentage / 100);
            salaries.put(employeeForRaise, newSalary);
        } else {
            System.out.println("Employee not found");
        }
        
        double totalSalary = 0;
        for (double salary : salaries.values()) {
            totalSalary += salary;
        }
        double averageSalary = totalSalary / salaries.size();
        System.out.println("Average Salary: " + averageSalary);
        
        double maxSalary = 0;
        for (double salary : salaries.values()) {
            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }
        
        System.out.println("\nHighest Paid Employee(s):");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == maxSalary) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
