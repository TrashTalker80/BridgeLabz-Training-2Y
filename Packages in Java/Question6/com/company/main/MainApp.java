package com.company.main;

import com.company.hr.*;
import com.company.payroll.Payroll;

public class MainApp {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Robert Brown", "Engineering", 75000.0);
        
        employee.displayEmployeeDetails();
        
        System.out.println("\n----------------------------\n");
        
        Payroll payroll = new Payroll();
        payroll.displayPayrollInfo(employee);
    }
}
