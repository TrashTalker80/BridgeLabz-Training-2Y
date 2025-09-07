import java.util.Arrays;

public class EmployeeBonus {

    public static double[][] generateSalaryAndService() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000; // Salary
            data[i][1] = (int) (Math.random() * 10) + 1;      // Years of service
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] newData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double bonusRate = data[i][1] > 5 ? 0.05 : 0.02;
            newData[i][1] = data[i][0] * bonusRate; // Bonus
            newData[i][0] = data[i][0] + newData[i][1]; // New salary
        }
        return newData;
    }

    public static void displayBonusDetails(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Employee\tOld Salary\tYears of Service\tBonus\t\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.0f\t\t\t%.2f\t\t%.2f%n", (i + 1), oldData[i][0], oldData[i][1], newData[i][1], newData[i][0]);
            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];
        }

        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
        System.out.printf("Total Bonus Amount: %.2f%n", totalBonus);
    }

    public static void main(String[] args) {
        double[][] oldData = generateSalaryAndService();
        double[][] newData = calculateNewSalaryAndBonus(oldData);
        displayBonusDetails(oldData, newData);
    }
}

