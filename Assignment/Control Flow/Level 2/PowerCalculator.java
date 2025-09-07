import java.util.Scanner;

class PowerCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int number = input.nextInt();
        int power = input.nextInt();
        
        if (number > 0 && power > 0) {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }
            System.out.println("Result: " + result);
        }
        
        input.close();
    }
}