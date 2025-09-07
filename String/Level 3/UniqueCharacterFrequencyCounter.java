import java.util.Scanner;

public class UniqueCharacterFrequencyCounter {

    private static final int ASCII_CHARACTER_COUNT = 256;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        Object[][] frequencies = findFrequenciesUsingUnique(text);

        System.out.println("Character frequencies:");
        for (Object[] row : frequencies) {
            System.out.println("'" + row[0] + "': " + row[1]);
        }
        scanner.close();
    }
    
    public static char[] findUniqueCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return new char[0];
        }
        StringBuilder uniqueChars = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (uniqueChars.indexOf(String.valueOf(currentChar)) == -1) {
                uniqueChars.append(currentChar);
            }
        }
        return uniqueChars.toString().toCharArray();
    }

    public static Object[][] findFrequenciesUsingUnique(String text) {
        if (text == null || text.isEmpty()) {
            return new Object[0][0];
        }

        char[] uniqueChars = findUniqueCharacters(text);
        int[] freqArray = new int[ASCII_CHARACTER_COUNT];
        
        for (char c : text.toCharArray()) {
            freqArray[c]++;
        }
        
        Object[][] result = new Object[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = uniqueChars[i];
            result[i][1] = freqArray[uniqueChars[i]];
        }
        
        return result;
    }
}