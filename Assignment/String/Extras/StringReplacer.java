public class StringReplacer {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        if (sentence == null || oldWord == null || newWord == null) {
            return sentence;
        }
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String originalSentence = "The quick brown fox jumps over the lazy dog.";
        String wordToReplace = "fox";
        String replacement = "cat";

        String result = replaceWord(originalSentence, wordToReplace, replacement);

        System.out.println("Original: " + originalSentence);
        System.out.println("Replaced: " + result);
    }
}