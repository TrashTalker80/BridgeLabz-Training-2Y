import java.util.HashMap;
import java.util.Map;

public class ExamResultsTopperPerSubject {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> examResults = new HashMap<>();
        
        Map<String, Integer> mathScores = new HashMap<>();
        mathScores.put("Alice", 95);
        mathScores.put("Bob", 87);
        mathScores.put("Charlie", 92);
        examResults.put("Mathematics", mathScores);
        
        Map<String, Integer> scienceScores = new HashMap<>();
        scienceScores.put("Alice", 88);
        scienceScores.put("Bob", 91);
        scienceScores.put("Charlie", 85);
        examResults.put("Science", scienceScores);
        
        Map<String, Integer> englishScores = new HashMap<>();
        englishScores.put("Alice", 92);
        englishScores.put("Bob", 78);
        englishScores.put("Charlie", 89);
        examResults.put("English", englishScores);
        
        System.out.println("Top scorer per subject:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examResults.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> scores = subjectEntry.getValue();
            
            String topStudent = null;
            int topScore = 0;
            
            for (Map.Entry<String, Integer> studentEntry : scores.entrySet()) {
                if (studentEntry.getValue() > topScore) {
                    topScore = studentEntry.getValue();
                    topStudent = studentEntry.getKey();
                }
            }
            
            System.out.println(subject + ": " + topStudent + " with " + topScore + " marks");
        }
        
        System.out.println("\nAverage score per subject:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examResults.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> scores = subjectEntry.getValue();
            
            int total = 0;
            for (int score : scores.values()) {
                total += score;
            }
            double average = (double) total / scores.size();
            
            System.out.println(subject + ": " + average);
        }
        
        System.out.println("\nSubjects with at least one student scoring above 90:");
        for (Map.Entry<String, Map<String, Integer>> subjectEntry : examResults.entrySet()) {
            String subject = subjectEntry.getKey();
            Map<String, Integer> scores = subjectEntry.getValue();
            
            boolean hasAbove90 = false;
            for (int score : scores.values()) {
                if (score > 90) {
                    hasAbove90 = true;
                    break;
                }
            }
            
            if (hasAbove90) {
                System.out.println(subject);
            }
        }
    }
}
