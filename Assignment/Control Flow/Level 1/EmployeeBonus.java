import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double salary = input.nextDouble();
        int yearsOfService = input.nextInt();
        
        double bonusAmount = 0;
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
        }
        
        System.out.println("Bonus amount: " + bonusAmount);
        
        input.close();
    }
}