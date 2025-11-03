import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        int letterCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (!Character.isWhitespace(ch)) {
                specialCharCount++;
            }
        }
        
        System.out.println("Total letters: " + letterCount);
        System.out.println("Total digits: " + digitCount);
        System.out.println("Total special characters: " + specialCharCount);
        
        scanner.close();
    }
}
