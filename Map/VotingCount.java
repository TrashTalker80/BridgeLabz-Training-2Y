import java.util.HashMap;
import java.util.Map;

public class VotingCount {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        
        String[] castVotes = {"Alice", "Bob", "Charlie", "Alice", "Bob", "Alice", "Charlie", "Alice", "Bob", "Alice"};
        
        for (String candidate : castVotes) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }
        
        String winner = null;
        int maxVotes = 0;
        
        System.out.println("Vote Count:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        
        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}
