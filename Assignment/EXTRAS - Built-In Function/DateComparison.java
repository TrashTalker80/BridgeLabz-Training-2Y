import java.time.LocalDate;
import java.util.Scanner;

class DateComparison {
    public static void main(String[] args) {
        LocalDate[] dates = getTwoDates();
        compareAndDisplayResults(dates[0], dates[1]);
    }
    
    private static LocalDate[] getTwoDates() {
        Scanner input = new Scanner(System.in);
        LocalDate[] dates = new LocalDate[2];
        
        System.out.println("Enter first date (yyyy-mm-dd):");
        dates[0] = LocalDate.parse(input.nextLine());
        
        System.out.println("Enter second date (yyyy-mm-dd):");
        dates[1] = LocalDate.parse(input.nextLine());
        
        input.close();
        return dates;
    }
    
    private static void compareAndDisplayResults(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            System.out.println("First date is before second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after second date");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same");
        }
    }
}