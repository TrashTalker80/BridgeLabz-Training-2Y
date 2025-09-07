import java.util.Scanner;

class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total = 0.0;
        
        while (true) {
            double userInput = input.nextDouble();
            
            if (userInput <= 0) {
                break;
            }
            
            total += userInput;
        }
        
        System.out.println("Total: " + total);
        
        input.close();
    }
}