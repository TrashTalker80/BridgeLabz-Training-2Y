import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class DateArithmetic {
    public static void main(String[] args) {
        LocalDate inputDate = getDateInput();
        LocalDate resultDate = performDateArithmetic(inputDate);
        displayResults(inputDate, resultDate);
    }
    
    private static LocalDate getDateInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter date (yyyy-mm-dd):");
        String dateStr = input.nextLine();
        input.close();
        return LocalDate.parse(dateStr);
    }
    
    private static LocalDate performDateArithmetic(LocalDate date) {
        LocalDate result = date.plusDays(7)
                              .plusMonths(1)
                              .plusYears(2)
                              .minusWeeks(3);
        return result;
    }
    
    private static void displayResults(LocalDate original, LocalDate result) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Original date: " + original.format(formatter));
        System.out.println("After arithmetic: " + result.format(formatter));
    }
}