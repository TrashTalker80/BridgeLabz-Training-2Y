import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountryCapitalLookup {
    public static void main(String[] args) {
        Map<String, String> countryCapital = new HashMap<>();
        
        countryCapital.put("India", "New Delhi");
        countryCapital.put("USA", "Washington D.C.");
        countryCapital.put("France", "Paris");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("Australia", "Canberra");
        countryCapital.put("Brazil", "Brasilia");
        countryCapital.put("Canada", "Ottawa");
        
        String searchCountry = "India";
        if (countryCapital.containsKey(searchCountry)) {
            System.out.println("Capital of " + searchCountry + ": " + countryCapital.get(searchCountry));
        } else {
            System.out.println("Unknown country");
        }
        
        Map<String, String> sortedCountries = new TreeMap<>(countryCapital);
        System.out.println("\nCountries and Capitals (Alphabetically):");
        for (Map.Entry<String, String> entry : sortedCountries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
