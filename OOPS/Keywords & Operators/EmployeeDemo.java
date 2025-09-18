public class EmployeeDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Rajesh Kumar", 101, "Software Engineer");
        Employee emp2 = new Employee("Priya Sharma", 102, "Project Manager");
        Employee emp3 = new Employee("Amit Patel", 103, "System Analyst");
        
        System.out.println("Company: " + Employee.getCompanyName());
        System.out.println();
        
        emp1.displayEmployeeDetails();
        System.out.println();
        
        emp2.displayEmployeeDetails();
        System.out.println();
        
        emp3.displayEmployeeDetails();
        System.out.println();
        
        Employee.displayTotalEmployees();
        
        System.out.println("\nInstance Check:");
        if (emp1 instanceof Employee) {
            System.out.println("emp1 is an instance of Employee class");
            System.out.println("Employee ID: " + emp1.getId());
        }
        
        Object obj = emp2;
        if (obj instanceof Employee) {
            System.out.println("obj (emp2) is an instance of Employee class");
            Employee empObj = (Employee) obj;
            System.out.println("Employee Name: " + empObj.getName());
            System.out.println("Designation: " + empObj.getDesignation());
        }
        
        if (emp3 instanceof Employee) {
            System.out.println("emp3 is confirmed as Employee instance");
        }
    }
}

class Employee {
    private static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;
    
    private String name;
    private final int id;
    private String designation;
    
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    
    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }
    
    public static String getCompanyName() {
        return companyName;
    }
    
    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee ID: " + this.id);
        System.out.println("Designation: " + this.designation);
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDesignation() {
        return this.designation;
    }
}