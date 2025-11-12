import java.util.HashMap;
import java.util.Map;

public class WordFrequencyInSentence {
    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";
        Map<String, Integer> wordCount = new HashMap<>();
        
        String[] words = sentence.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
