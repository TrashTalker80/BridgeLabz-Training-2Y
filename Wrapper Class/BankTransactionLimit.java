public class BankTransactionLimit {
    public static double calculateRemainingLimit(Double limit, double withdrawalAmount) {
        if (limit == null) {
            return 0.0;
        }
        return limit - withdrawalAmount;
    }
    
    public static void main(String[] args) {
        Double accountLimit1 = 5000.0;
        Double accountLimit2 = null;
        double accountLimit3 = 10000.0;
        
        double withdrawal = 1500.0;
        
        double remaining1 = calculateRemainingLimit(accountLimit1, withdrawal);
        System.out.println("Account 1 remaining limit: " + remaining1);
        
        double remaining2 = calculateRemainingLimit(accountLimit2, withdrawal);
        System.out.println("Account 2 remaining limit (null): " + remaining2);
        
        double remaining3 = calculateRemainingLimit(accountLimit3, withdrawal);
        System.out.println("Account 3 remaining limit: " + remaining3);
    }
}
