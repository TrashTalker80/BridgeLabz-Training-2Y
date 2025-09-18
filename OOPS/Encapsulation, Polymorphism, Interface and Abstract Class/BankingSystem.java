import java.util.*;

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + String.format("%.2f", amount));
            System.out.println("New Balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + String.format("%.2f", amount));
            System.out.println("New Balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }
    }
    
    public abstract double calculateInterest();
    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + maskAccountNumber());
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Interest Earned: $" + String.format("%.2f", calculateInterest()));
    }
    
    private String maskAccountNumber() {
        if (accountNumber.length() <= 4) {
            return accountNumber;
        }
        return "****" + accountNumber.substring(accountNumber.length() - 4);
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;
    private double minimumBalance;
    private static final double LOAN_MULTIPLIER = 2.5;
    
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        if (amount <= eligibility && getBalance() >= minimumBalance) {
            System.out.println("Loan approved for: $" + String.format("%.2f", amount));
            return true;
        } else {
            System.out.println("Loan rejected. Maximum eligible amount: $" + String.format("%.2f", eligibility));
            return false;
        }
    }
    
    @Override
    public double calculateLoanEligibility() {
        if (getBalance() >= minimumBalance) {
            return getBalance() * LOAN_MULTIPLIER;
        }
        return 0;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        }
    }
    
    public double getMinimumBalance() {
        return minimumBalance;
    }
    
    public void setMinimumBalance(double minimumBalance) {
        if (minimumBalance >= 0) {
            this.minimumBalance = minimumBalance;
        }
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    private double monthlyTransactionLimit;
    private int transactionCount;
    private static final double CURRENT_ACCOUNT_INTEREST_RATE = 0.0;
    private static final double LOAN_MULTIPLIER = 1.5;
    
    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit, double monthlyTransactionLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyTransactionLimit = monthlyTransactionLimit;
        this.transactionCount = 0;
    }
    
    @Override
    public double calculateInterest() {
        return CURRENT_ACCOUNT_INTEREST_RATE;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            transactionCount++;
            System.out.println("Withdrawn: $" + String.format("%.2f", amount));
            System.out.println("New Balance: $" + String.format("%.2f", getBalance()));
            if (getBalance() < 0) {
                System.out.println("Warning: Using overdraft facility");
            }
        } else {
            System.out.println("Withdrawal exceeds available balance and overdraft limit");
        }
    }
    
    @Override
    public boolean applyForLoan(double amount) {
        double eligibility = calculateLoanEligibility();
        if (amount <= eligibility && transactionCount >= 10) {
            System.out.println("Loan approved for: $" + String.format("%.2f", amount));
            return true;
        } else {
            System.out.println("Loan rejected. Eligibility: $" + String.format("%.2f", eligibility));
            if (transactionCount < 10) {
                System.out.println("Minimum 10 transactions required. Current: " + transactionCount);
            }
            return false;
        }
    }
    
    @Override
    public double calculateLoanEligibility() {
        if (transactionCount >= 10) {
            return monthlyTransactionLimit * LOAN_MULTIPLIER;
        }
        return 0;
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
        }
    }
    
    public int getTransactionCount() {
        return transactionCount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        
        SavingsAccount savings1 = new SavingsAccount("SAV10001234", "John Doe", 5000, 0.035, 1000);
        SavingsAccount savings2 = new SavingsAccount("SAV10005678", "Jane Smith", 15000, 0.04, 2000);
        
        CurrentAccount current1 = new CurrentAccount("CUR20001234", "Bob Johnson", 10000, 2000, 50000);
        CurrentAccount current2 = new CurrentAccount("CUR20005678", "Alice Brown", 25000, 5000, 100000);
        
        accounts.add(savings1);
        accounts.add(savings2);
        accounts.add(current1);
        accounts.add(current2);
        
        System.out.println("=== Banking System ===\n");
        
        System.out.println("--- Initial Account Status ---");
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligibility: $" + String.format("%.2f", loanable.calculateLoanEligibility()));
            }
            System.out.println("-------------------");
        }
        
        System.out.println("\n--- Performing Transactions ---");
        
        savings1.deposit(2000);
        savings1.withdraw(500);
        savings1.applyForLoan(15000);
        System.out.println();
        
        current1.deposit(5000);
        for (int i = 0; i < 12; i++) {
            current1.withdraw(100);
        }
        current1.applyForLoan(60000);
        System.out.println();
        
        current2.withdraw(27000);
        System.out.println();
        
        System.out.println("\n--- Final Account Status ---");
        double totalBalance = 0;
        double totalInterest = 0;
        
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("-------------------");
            totalBalance += account.getBalance();
            totalInterest += account.calculateInterest();
        }
        
        System.out.println("\n=== Bank Summary ===");
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("Total Balance: $" + String.format("%.2f", totalBalance));
        System.out.println("Total Interest to be Paid: $" + String.format("%.2f", totalInterest));
    }
}