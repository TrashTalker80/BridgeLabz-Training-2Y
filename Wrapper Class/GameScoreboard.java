public class GameScoreboard {
    public static void main(String[] args) {
        Integer[] scores = {100, 250, null, 300, null, 150, 200, null, 175};
        
        int notPlayedCount = 0;
        int totalScore = 0;
        
        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalScore += score;
            }
        }
        
        System.out.println("Players who have not played: " + notPlayedCount);
        System.out.println("Total of valid scores: " + totalScore);
    }
}
