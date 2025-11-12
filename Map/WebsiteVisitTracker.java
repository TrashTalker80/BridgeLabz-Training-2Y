import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebsiteVisitTracker {
    public static void main(String[] args) {
        Map<String, Integer> pageVisits = new HashMap<>();
        
        String[] visits = {"home", "about", "products", "home", "products", "contact", "home", "about", "home"};
        
        for (String page : visits) {
            pageVisits.put(page, pageVisits.getOrDefault(page, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> sortedPages = new ArrayList<>(pageVisits.entrySet());
        Collections.sort(sortedPages, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        
        System.out.println("Pages sorted by visit count (descending):");
        for (Map.Entry<String, Integer> entry : sortedPages) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " visits");
        }
        
        String mostVisitedPage = sortedPages.get(0).getKey();
        int maxVisits = sortedPages.get(0).getValue();
        System.out.println("\nMost visited page: " + mostVisitedPage + " with " + maxVisits + " visits");
    }
}
