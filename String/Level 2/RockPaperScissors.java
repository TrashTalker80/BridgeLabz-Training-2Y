import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "";
        }
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "draw";
        }
        switch (userChoice) {
            case "rock":
                return (computerChoice.equals("scissors")) ? "user" : "computer";
            case "paper":
                return (computerChoice.equals("rock")) ? "user" : "computer";
            case "scissors":
                return (computerChoice.equals("paper")) ? "user" : "computer";
        }
        return "invalid";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int games) {
        if (games == 0) return new String[2][2];
        double userWinPercentage = ((double) userWins / games) * 100;
        double computerWinPercentage = ((double) computerWins / games) * 100;

        String[][] stats = new String[2][2];
        stats[0][0] = "User";
        stats[0][1] = String.format("%.2f%%", userWinPercentage);
        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f%%", computerWinPercentage);
        return stats;
    }

    public static void displayGameResults(String[][] gameData, String[][] stats) {
        System.out.println("\n--- Game Results ---");
        System.out.printf("%-10s | %-10s | %-10s\n", "User", "Computer", "Winner");
        System.out.println("------------------------------------");
        for(String[] round : gameData){
            if (round[0] != null) {
                System.out.printf("%-10s | %-10s | %-10s\n", round[0], round[1], round[2]);
            }
        }
        System.out.println("\n--- Statistics ---");
        System.out.printf("%-10s | %-10s\n", "Player", "Win %");
        System.out.println("----------------------");
        System.out.printf("%-10s | %-10s\n", stats[0][0], stats[0][1]);
        System.out.printf("%-10s | %-10s\n", stats[1][0], stats[1][1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int numGames = scanner.nextInt();

        int userWins = 0;
        int computerWins = 0;
        String[][] gameData = new String[numGames][3];

        for (int i = 0; i < numGames; i++) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.next().toLowerCase();
            
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please try again.");
                i--; // Repeat this round
                continue;
            }

            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);
            
            gameData[i][0] = userChoice;
            gameData[i][1] = computerChoice;
            gameData[i][2] = winner;

            if (winner.equals("user")) {
                userWins++;
            } else if (winner.equals("computer")) {
                computerWins++;
            }
        }
        
        String[][] stats = calculateStats(userWins, computerWins, numGames);
        displayGameResults(gameData, stats);
        
        scanner.close();
    }
}