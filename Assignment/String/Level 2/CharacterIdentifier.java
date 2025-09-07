import java.util.Scanner;

public class CharacterIdentifier {

    public static String checkCharType(char ch) {
        char lowerCh = ch;
        if (lowerCh >= 'A' && lowerCh <= 'Z') {
            lowerCh = (char) (lowerCh + 32); // Convert to lowercase
        }

        if (lowerCh >= 'a' && lowerCh <= 'z') {
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] getCharacterTypes(String text) {
        String[][] charTypes = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            charTypes[i][0] = String.valueOf(text.charAt(i));
            charTypes[i][1] = checkCharType(text.charAt(i));
        }
        return charTypes;
    }

    public static void displayResults(String[][] data) {
        System.out.println("--------------------------");
        System.out.printf("%-10s | %s\n", "Character", "Type");
        System.out.println("--------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s | %s\n", row[0], row[1]);
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        String[][] characterTypes = getCharacterTypes(userInput);
        displayResults(characterTypes);
        
        scanner.close();
    }
}