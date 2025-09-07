public class FindLongestWord {

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence to find the longest word";
        System.out.println("Sentence: " + sentence);
        System.out.println("Longest word: " + findLongestWord(sentence));
    }
}