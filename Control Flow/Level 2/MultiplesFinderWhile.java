import java.util.Scanner;

class MultiplesFinderWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int number = input.nextInt();
        
        if (number > 0 && number < 100) {
            int counter = 100;
            while (counter >= 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }
        
        input.close();
    }
}