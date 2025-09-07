import java.util.Scanner;

class FibonacciGenerator {
    public static void main(String[] args) {
        int terms = getNumberOfTerms();
        generateFibonacci(terms);
    }
    
    private static int getNumberOfTerms() {
        Scanner input = new Scanner(System.in);
        int terms = input.nextInt();
        input.close();
        return terms;
    }
    
    private static void generateFibonacci(int terms) {
        if (terms <= 0) {
            return;
        }
        
        int first = 0;
        int second = 1;
        
        if (terms >= 1) {
            System.out.print(first + " ");
        }
        if (terms >= 2) {
            System.out.print(second + " ");
        }
        
        for (int i = 3; i <= terms; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }
}