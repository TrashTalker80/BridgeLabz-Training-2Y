import java.util.HashMap;
import java.util.Map;

public class EmployeeDepartmentMapping {
    public static void main(String[] args) {
        Map<Integer, String> employeeDepartment = new HashMap<>();
        
        employeeDepartment.put(101, "IT");
        employeeDepartment.put(102, "HR");
        employeeDepartment.put(103, "IT");
        employeeDepartment.put(104, "Finance");
        employeeDepartment.put(105, "HR");
        employeeDepartment.put(106, "IT");
        
        int changeEmployeeId = 102;
        employeeDepartment.put(changeEmployeeId, "Finance");
        
        String searchDepartment = "IT";
        System.out.println("Employees in " + searchDepartment + ":");
        for (Map.Entry<Integer, String> entry : employeeDepartment.entrySet()) {
            if (entry.getValue().equals(searchDepartment)) {
                System.out.println("Employee ID: " + entry.getKey());
            }
        }
        
        Map<String, Integer> departmentCount = new HashMap<>();
        for (String department : employeeDepartment.values()) {
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }
        
        System.out.println("\nTotal employees per department:");
        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " employees");
        }
    }
}
