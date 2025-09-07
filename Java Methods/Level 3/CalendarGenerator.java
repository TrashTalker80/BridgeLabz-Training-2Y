import java.util.Scanner;

public class CalendarGenerator {

    public static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m) / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("  " + getMonthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int firstDay = getFirstDayOfMonth(month, year);
        int numberOfDays = getNumberOfDaysInMonth(month, year);

        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i <= numberOfDays; i++) {
            System.out.printf("%3d", i);
            if ((firstDay + i) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month and year (e.g., 07 2005): ");
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        displayCalendar(month, year);
        scanner.close();
    }
}

