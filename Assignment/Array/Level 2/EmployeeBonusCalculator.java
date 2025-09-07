import java.util.Scanner;

class EmployeeBonusCalculator {
    
    public static void inputEmployeeData(double[] salaries, double[] yearsOfService, Scanner input) {
        for (int i = 0; i < salaries.length; i++) {
            while (true) {
                System.out.print("Employee " + (i + 1) + " salary: ");
                double salary = input.nextDouble();
                System.out.print("Employee " + (i + 1) + " years of service: ");
                double years = input.nextDouble();
                
                if (salary <= 0 || years < 0) {
                    System.out.println("Invalid input. Please enter positive values.");
                    continue;
                }
                
                salaries[i] = salary;
                yearsOfService[i] = years;
                break;
            }
        }
    }
    
    public static void calculateBonuses(double[] salaries, double[] yearsOfService, double[] bonuses, double[] newSalaries) {
        for (int i = 0; i < salaries.length; i++) {
            double bonusPercent = yearsOfService[i] > 5 ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercent;
            newSalaries[i] = salaries[i] + bonuses[i];
        }
    }
    
    public static double calculateTotal(double[] array) {
        double total = 0.0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total;
    }
    
    public static void displayResults(double totalOldSalary, double totalNewSalary, double totalBonus) {
        System.out.println("\n=== ZARA BONUS CALCULATION RESULTS ===");
        System.out.println("Total Old Salary: $" + String.format("%.2f", totalOldSalary));
        System.out.println("Total Bonus Payout: $" + String.format("%.2f", totalBonus));
        System.out.println("Total New Salary: $" + String.format("%.2f", totalNewSalary));
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        
        System.out.println("Enter salary and years of service for 10 employees:");
        inputEmployeeData(salaries, yearsOfService, input);
        
        calculateBonuses(salaries, yearsOfService, bonuses, newSalaries);
        
        double totalOldSalary = calculateTotal(salaries);
        double totalBonus = calculateTotal(bonuses);
        double totalNewSalary = calculateTotal(newSalaries);
        
        displayResults(totalOldSalary, totalNewSalary, totalBonus);
        
        input.close();
    }
}
