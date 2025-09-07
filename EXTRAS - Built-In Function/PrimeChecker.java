import java.util.Scanner;

class PrimeChecker {
    public static void main(String[] args) {
        int number = getNumber();
        boolean isPrime = checkPrime(number);
        displayResult(number, isPrime);
    }
    
    private static int getNumber() {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        return number;
    }
    
    private static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static void displayResult(int number, boolean isPrime) {
        if (isPrime) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
}