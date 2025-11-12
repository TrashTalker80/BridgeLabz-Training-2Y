import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LibraryBookCatalog {
    public static void main(String[] args) {
        Map<String, String> catalog = new HashMap<>();
        
        catalog.put("978-1234567890", "Java Programming");
        catalog.put("978-9876543210", "Data Structures");
        catalog.put("978-1111111111", "Algorithms");
        catalog.put("978-2222222222", "Design Patterns");
        
        String searchIsbn = "978-1234567890";
        if (catalog.containsKey(searchIsbn)) {
            System.out.println("Book found: " + catalog.get(searchIsbn));
        } else {
            System.out.println("Book not found");
        }
        
        catalog.remove("978-9876543210");
        
        Map<String, String> sortedCatalog = new TreeMap<>(catalog);
        System.out.println("\nCatalog (sorted by ISBN):");
        for (Map.Entry<String, String> entry : sortedCatalog.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        String searchTitle = "Algorithms";
        System.out.println("\nSearching for title: " + searchTitle);
        boolean found = false;
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equals(searchTitle)) {
                System.out.println("Found: ISBN " + entry.getKey());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Title not found");
        }
    }
}
