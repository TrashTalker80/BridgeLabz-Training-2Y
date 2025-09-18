import java.util.*;

interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    private String department;
    
    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary: $" + calculateSalary());
        System.out.println("Department: " + department);
        System.out.println();
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}

class FullTimeEmployee extends Employee implements Department {
    private double annualBonus;
    
    public FullTimeEmployee(String employeeId, String name, double baseSalary, double annualBonus) {
        super(employeeId, name, baseSalary);
        this.annualBonus = annualBonus;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (annualBonus / 12);
    }
    
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment() + " (Full-time Employee)";
    }
    
    public double getAnnualBonus() {
        return annualBonus;
    }
    
    public void setAnnualBonus(double annualBonus) {
        if (annualBonus >= 0) {
            this.annualBonus = annualBonus;
        }
    }
}

class PartTimeEmployee extends Employee implements Department {
    private double hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(String employeeId, String name, double baseSalary, double hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment() + " (Part-time Employee)";
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        }
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        }
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee ftEmployee1 = new FullTimeEmployee("FT001", "John Doe", 50000, 10000);
        ftEmployee1.assignDepartment("Engineering");
        
        FullTimeEmployee ftEmployee2 = new FullTimeEmployee("FT002", "Jane Smith", 60000, 15000);
        ftEmployee2.assignDepartment("Marketing");
        
        PartTimeEmployee ptEmployee1 = new PartTimeEmployee("PT001", "Bob Johnson", 0, 120, 25);
        ptEmployee1.assignDepartment("Support");
        
        PartTimeEmployee ptEmployee2 = new PartTimeEmployee("PT002", "Alice Brown", 0, 80, 30);
        ptEmployee2.assignDepartment("Sales");
        
        employees.add(ftEmployee1);
        employees.add(ftEmployee2);
        employees.add(ptEmployee1);
        employees.add(ptEmployee2);
        
        System.out.println("=== Employee Management System ===\n");
        
        for (Employee employee : employees) {
            employee.displayDetails();
            if (employee instanceof Department) {
                Department dept = (Department) employee;
                System.out.println(dept.getDepartmentDetails());
                System.out.println("-------------------");
            }
        }
        
        System.out.println("\nTotal Employees: " + employees.size());
        
        double totalSalaryExpense = 0;
        for (Employee employee : employees) {
            totalSalaryExpense += employee.calculateSalary();
        }
        System.out.println("Total Monthly Salary Expense: $" + totalSalaryExpense);
    }
}