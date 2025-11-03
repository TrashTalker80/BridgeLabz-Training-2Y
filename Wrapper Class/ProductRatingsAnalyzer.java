import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3, 4, 5};
        ArrayList<Integer> newRatings = new ArrayList<>();
        newRatings.add(5);
        newRatings.add(null);
        newRatings.add(4);
        newRatings.add(null);
        newRatings.add(3);
        
        ArrayList<Integer> combinedRatings = new ArrayList<>();
        
        for (int rating : oldRatings) {
            combinedRatings.add(rating);
        }
        
        for (Integer rating : newRatings) {
            if (Objects.nonNull(rating)) {
                combinedRatings.add(rating);
            }
        }
        
        int sum = 0;
        for (Integer rating : combinedRatings) {
            sum += rating;
        }
        double averageRating = (double) sum / combinedRatings.size();
        
        System.out.println("Total valid ratings: " + combinedRatings.size());
        System.out.println("Average rating: " + averageRating);
    }
}
