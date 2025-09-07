import java.util.Scanner;
import java.util.Random;

public class DeckOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter the number of cards to distribute to each player: ");
        int cardsPerPlayer = scanner.nextInt();
        
        String[] deck = initializeDeck(suits, ranks);
        shuffleDeck(deck);
        
        String[][] playersHands = distributeCards(deck, numPlayers, cardsPerPlayer);
        
        if (playersHands != null) {
            printPlayerCards(playersHands);
        } else {
            System.out.println("Cannot distribute cards. Not enough cards in the deck for the given number of players and cards per player.");
        }
        
        scanner.close();
    }

    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            return null;
        }

        String[][] playersHands = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                playersHands[j][i] = deck[cardIndex++];
            }
        }
        return playersHands;
    }

    public static void printPlayerCards(String[][] playersHands) {
        for (int i = 0; i < playersHands.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s cards:");
            for (String card : playersHands[i]) {
                System.out.println("  " + card);
            }
        }
    }
}