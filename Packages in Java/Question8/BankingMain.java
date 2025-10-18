import com.bank.util.InterestCalculator;
import static java.lang.Math.*;

public class BankingMain {
    public static void main(String[] args) {
        InterestCalculator calculator = new InterestCalculator();
        
        double principal = 10000;
        double rate = 5;
        double time = 2;
        
        double simpleInterest = calculator.calculateSimpleInterest(principal, rate, time);
        System.out.println("Principal Amount: $" + principal);
        System.out.println("Rate of Interest: " + rate + "%");
        System.out.println("Time Period: " + time + " years");
        System.out.println("Simple Interest: $" + simpleInterest);
        System.out.println("Total Amount with SI: $" + (principal + simpleInterest));
        
        System.out.println("\n----------------------------\n");
        
        double compoundInterest = calculator.calculateCompoundInterest(principal, rate, time);
        System.out.println("Compound Interest: $" + compoundInterest);
        System.out.println("Total Amount with CI: $" + (principal + compoundInterest));
        
        System.out.println("\nUsing pow from static import: " + pow(2, 3));
    }
}
