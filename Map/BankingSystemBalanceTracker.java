import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystemBalanceTracker {
    public static void main(String[] args) {
        Map<String, Double> customerBalances = new HashMap<>();
        
        customerBalances.put("ACC001", 50000.0);
        customerBalances.put("ACC002", 75000.0);
        customerBalances.put("ACC003", 30000.0);
        customerBalances.put("ACC004", 90000.0);
        customerBalances.put("ACC005", 45000.0);
        
        String depositAccount = "ACC001";
        double depositAmount = 10000.0;
        customerBalances.put(depositAccount, customerBalances.get(depositAccount) + depositAmount);
        
        String withdrawAccount = "ACC003";
        double withdrawAmount = 5000.0;
        if (customerBalances.get(withdrawAccount) >= withdrawAmount) {
            customerBalances.put(withdrawAccount, customerBalances.get(withdrawAccount) - withdrawAmount);
        } else {
            System.out.println("Insufficient balance for withdrawal");
        }
        
        List<Map.Entry<String, Double>> sortedByBalance = new ArrayList<>(customerBalances.entrySet());
        Collections.sort(sortedByBalance, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        
        System.out.println("Customers sorted by balance (descending):");
        for (Map.Entry<String, Double> entry : sortedByBalance) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\nTop 3 customers:");
        for (int i = 0; i < Math.min(3, sortedByBalance.size()); i++) {
            System.out.println(sortedByBalance.get(i).getKey() + ": " + sortedByBalance.get(i).getValue());
        }
    }
}
