import java.util.Scanner;

class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;
        
        System.out.println("Enter salary and years of service for 10 employees:");
        
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            
            while (true) {
                System.out.print("Salary: ");
                salaries[i] = input.nextDouble();
                
                System.out.print("Years of Service: ");
                yearsOfService[i] = input.nextDouble();
                
                if (salaries[i] > 0 && yearsOfService[i] >= 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter positive values.");
                    i--;
                    break;
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05;
            } else {
                bonuses[i] = salaries[i] * 0.02;
            }
            
            newSalaries[i] = salaries[i] + bonuses[i];
            
            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }
        
        System.out.println("\n=== Company Zara Bonus Summary ===");
        System.out.println("Total Old Salary: $" + String.format("%.2f", totalOldSalary));
        System.out.println("Total Bonus Payout: $" + String.format("%.2f", totalBonus));
        System.out.println("Total New Salary: $" + String.format("%.2f", totalNewSalary));
        
        input.close();
    }
}
