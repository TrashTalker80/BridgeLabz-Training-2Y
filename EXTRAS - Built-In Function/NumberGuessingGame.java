import java.util.Scanner;

class NumberGuessingGame {
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100. I'll try to guess it!");
        playGame();
        input.close();
    }
    
    private static void playGame() {
        int low = 1;
        int high = 100;
        boolean guessed = false;
        
        while (!guessed) {
            int guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);
            
            String feedback = getUserFeedback();
            
            if (feedback.equals("correct")) {
                System.out.println("I guessed your number!");
                guessed = true;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
    }
    
    private static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }
    
    private static String getUserFeedback() {
        System.out.println("Enter 'high' if too high, 'low' if too low, 'correct' if right:");
        return input.nextLine().toLowerCase();
    }
}