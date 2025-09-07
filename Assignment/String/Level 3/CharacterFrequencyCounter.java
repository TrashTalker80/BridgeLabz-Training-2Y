import java.util.Scanner;

public class CharacterFrequencyCounter {

    private static final int ASCII_CHARACTER_COUNT = 256;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        Object[][] frequencies = findCharacterFrequencies(text);

        System.out.println("Character frequencies:");
        for (Object[] row : frequencies) {
            System.out.println("'" + row[0] + "': " + row[1]);
        }
        scanner.close();
    }

    public static Object[][] findCharacterFrequencies(String text) {
        if (text == null || text.isEmpty()) {
            return new Object[0][0];
        }

        int[] freqArray = new int[ASCII_CHARACTER_COUNT];
        int uniqueCharCount = 0;

        for (char c : text.toCharArray()) {
            if (freqArray[c] == 0) {
                uniqueCharCount++;
            }
            freqArray[c]++;
        }

        Object[][] result = new Object[uniqueCharCount][2];
        int index = 0;

        for(int i = 0; i < text.length(); i++){
            char currentChar = text.charAt(i);
            boolean alreadyAdded = false;
            for(int j = 0; j < index; j++){
                if((char)result[j][0] == currentChar){
                    alreadyAdded = true;
                    break;
                }
            }
            if(!alreadyAdded){
                 result[index][0] = currentChar;
                 result[index][1] = freqArray[currentChar];
                 index++;
            }
        }
        return result;
    }
}