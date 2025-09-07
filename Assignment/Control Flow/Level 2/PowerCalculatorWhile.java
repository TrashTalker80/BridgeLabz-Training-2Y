import java.util.Scanner;

class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int number = input.nextInt();
        int power = input.nextInt();
        
        if (number > 0 && power > 0) {
            int result = 1;
            int counter = 0;
            while (counter < power) {
                result = result * number;
                counter++;
            }
            System.out.println("Result: " + result);
        }
        
        input.close();
    }
}