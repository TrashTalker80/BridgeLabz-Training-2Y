import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String employeeId;
    private String name;
    private String department;
    
    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
}

public class NameUppercasing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("EMP001", "john doe", "Engineering"),
            new Employee("EMP002", "jane smith", "Human Resources"),
            new Employee("EMP003", "bob johnson", "Marketing"),
            new Employee("EMP004", "alice williams", "Finance"),
            new Employee("EMP005", "charlie brown", "Operations")
        );
        
        System.out.println("HR Letter - Employee Names in Uppercase");
        System.out.println("========================================\n");
        
        System.out.println("Original Employee Names:");
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
        
        System.out.println("\nEmployee Names in Uppercase (Using String::toUpperCase):");
        employees.stream()
                 .map(Employee::getName)
                 .map(String::toUpperCase)
                 .forEach(System.out::println);
        
        System.out.println("\nFormatted HR Letter:");
        List<String> uppercaseNames = employees.stream()
                                               .map(Employee::getName)
                                               .map(String::toUpperCase)
                                               .collect(Collectors.toList());
        
        System.out.println("\nDear Employees,\n");
        System.out.println("The following employees are hereby recognized:\n");
        uppercaseNames.forEach(name -> System.out.println("- " + name));
        System.out.println("\nSincerely,");
        System.out.println("HR Department");
    }
}
