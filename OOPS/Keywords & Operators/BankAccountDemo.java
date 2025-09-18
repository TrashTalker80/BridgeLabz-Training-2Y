public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 1001234567890L, 5000.0);
        BankAccount account2 = new BankAccount("Jane Smith", 1001234567891L, 10000.0);
        
        System.out.println("Bank Name: " + BankAccount.bankName);
        System.out.println();
        
        account1.displayAccountDetails();
        System.out.println();
        
        account2.displayAccountDetails();
        System.out.println();
        
        System.out.println("Total Accounts in " + BankAccount.bankName + ": " + BankAccount.getTotalAccounts());
        
        System.out.println("\nInstance Check:");
        if (account1 instanceof BankAccount) {
            System.out.println("account1 is an instance of BankAccount class");
        }
        
        if (account2 instanceof BankAccount) {
            System.out.println("account2 is an instance of BankAccount class");
        }
        
        Object obj = account1;
        if (obj instanceof BankAccount) {
            System.out.println("Object is an instance of BankAccount class");
            BankAccount bankAccObj = (BankAccount) obj;
            System.out.println("Cast successful! Account holder: " + bankAccObj.getAccountHolderName());
        }
    }
}

class BankAccount {
    static String bankName = "State Bank of India";
    private static int totalAccounts = 0;
    
    private String accountHolderName;
    private final long accountNumber;
    private double balance;
    
    public BankAccount(String accountHolderName, long accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + this.accountHolderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: Rs. " + this.balance);
    }
    
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
}