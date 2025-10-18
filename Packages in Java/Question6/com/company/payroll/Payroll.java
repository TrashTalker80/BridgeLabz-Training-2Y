package com.company.payroll;

import com.company.hr.Employee;

public class Payroll {
    public double calculateBonus(Employee employee) {
        double bonus = employee.getSalary() * 0.10;
        double totalSalary = employee.getSalary() + bonus;
        return totalSalary;
    }

    public void displayPayrollInfo(Employee employee) {
        double totalSalary = calculateBonus(employee);
        System.out.println("Employee: " + employee.getName());
        System.out.println("Base Salary: $" + employee.getSalary());
        System.out.println("Bonus (10%): $" + (employee.getSalary() * 0.10));
        System.out.println("Total Salary with Bonus: $" + totalSalary);
    }
}
