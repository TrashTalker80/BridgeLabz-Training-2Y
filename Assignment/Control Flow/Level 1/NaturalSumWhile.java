import java.util.Scanner;

class NaturalSumWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int number = input.nextInt();
        
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            
            int loopSum = 0;
            int i = 1;
            while (i <= number) {
                loopSum += i;
                i++;
            }
            
            System.out.println("Formula result: " + formulaSum);
            System.out.println("Loop result: " + loopSum);
            System.out.println("Results match: " + (formulaSum == loopSum));
        }
        
        input.close();
    }
}