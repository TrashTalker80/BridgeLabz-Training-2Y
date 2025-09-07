import java.util.Scanner;

public class TextAnalyzer {

    public static String[] splitText(String text) {
        // This is a simplified split, assuming single spaces
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
        
        String trimmedText = text + " ";
        for (int i = 0; i < trimmedText.length(); i++) {
            if (trimmedText.charAt(i) == ' ') {
                if (!currentWord.isEmpty()) {
                    words[wordIndex] = currentWord;
                    wordIndex++;
                    currentWord = "";
                }
            } else {
                currentWord += trimmedText.charAt(i);
            }
        }
        return words;
    }
    
    public static int findStringLength(String str) {
        int count = 0;
        try {
            for (int i = 0; ; i++) {
                str.charAt(i);
                count++;
            }
        } catch (Exception e) {
            // Expected
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

    public static String[] findShortestAndLongest(String[][] wordsAndLengths) {
        if (wordsAndLengths.length == 0) {
            return new String[]{"", ""};
        }
        String shortest = wordsAndLengths[0][0];
        String longest = wordsAndLengths[0][0];
        int shortestLength = Integer.parseInt(wordsAndLengths[0][1]);
        int longestLength = Integer.parseInt(wordsAndLengths[0][1]);

        for (int i = 1; i < wordsAndLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsAndLengths[i][1]);
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortest = wordsAndLengths[i][0];
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longest = wordsAndLengths[i][0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String userInput = scanner.nextLine();

        String[] words = splitText(userInput);
        if (words.length > 0 && words[0] != null) {
            String[][] wordsAndLengths = getWordsAndLengths(words);
            String[] result = findShortestAndLongest(wordsAndLengths);

            System.out.println("Shortest word: " + result[0]);
            System.out.println("Longest word: " + result[1]);
        } else {
            System.out.println("No words found in the input.");
        }
        
        scanner.close();
    }
}