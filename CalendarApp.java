import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarApp {
    public static void main(String[] args) {
        // Get current date
        LocalDate today = LocalDate.now();
        int currentDay = today.getDayOfMonth();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        // Get information about the month
        YearMonth yearMonth = YearMonth.of(currentYear, currentMonth);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstDay = yearMonth.atDay(1);

        // Determine the starting day of the week (1=Monday, 7=Sunday)
        int startDay = firstDay.getDayOfWeek().getValue();

        // Print header
        System.out.println("\n     " + today.getMonth() + " " + currentYear);
        System.out.println("Mo Tu We Th Fr Sa Su");

        // Print initial spaces for the first week
        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        // Print days
        for (int day = 1; day <= daysInMonth; day++) {
            // Highlight today's date with brackets
            if (day == currentDay) {
                System.out.printf("[%2d]", day);
            } else {
                System.out.printf(" %2d ", day);
            }

            // Move to new line after Sunday
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n");
    }
}
