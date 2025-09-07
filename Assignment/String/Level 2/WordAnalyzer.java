import java.util.Scanner;

public class WordAnalyzer {

    public static String[] splitText(String text) {
        int wordCount = 0;
        if (text.length() > 0 && text.charAt(0) != ' ') {
            wordCount = 1;
        }
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && text.charAt(i - 1) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        String currentWord = "";
        int wordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (!currentWord.isEmpty()) {
                    words[wordIndex] = currentWord;
                    wordIndex++;
                    currentWord = "";
                }
            } else {
                currentWord += text.charAt(i);
            }
        }
        if (!currentWord.isEmpty()) {
            words[wordIndex] = currentWord;
        }
        return words;
    }
    
    public static int findStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    public static String[][] getWordsAndLengths(String[] words) {
        String[][] wordsAndLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordsAndLengths[i][0] = words[i];
            wordsAndLengths[i][1] = String.valueOf(findStringLength(words[i]));
        }
        return wordsAndLengths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        String[] words = splitText(userInput);
        String[][] wordsAndLengths = getWordsAndLengths(words);

        System.out.println("--------------------");
        System.out.printf("%-15s | %s\n", "Word", "Length");
        System.out.println("--------------------");
        for (String[] wordInfo : wordsAndLengths) {
            System.out.printf("%-15s | %s\n", wordInfo[0], Integer.parseInt(wordInfo[1]));
        }
        System.out.println("--------------------");
        
        scanner.close();
    }
}