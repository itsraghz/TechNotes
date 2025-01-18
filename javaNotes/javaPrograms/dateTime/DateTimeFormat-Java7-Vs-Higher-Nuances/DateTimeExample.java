import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeExample {
    public static void main(String[] args) {
        // Example date: December 30, 2024
        // This date is particularly interesting because it's at the end of the year
        // where yyyy and YYYY can show different results

        System.out.println("Date Format Demonstration - yyyy vs YYYY\n");

        // Java 7 style using SimpleDateFormat
        System.out.println("Java 7 Style (using SimpleDateFormat):");
        demonstrateJava7Style();
        System.out.println();

        // Java 8+ style using DateTimeFormatter
        System.out.println("Java 8+ Style (using DateTimeFormatter):");
        demonstrateModernStyle();
    }

    private static void demonstrateJava7Style() {
        // Create a Calendar instance for December 30, 2024
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.DECEMBER, 30); // Month is 0-based
        Date date = cal.getTime();

        // yyyy - Calendar year
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("yyyy format: " + sdfYear.format(date));

        // YYYY - Week-based year
        SimpleDateFormat sdfWeekYear = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("YYYY format: " + sdfWeekYear.format(date));

        System.out.println("Note: In Java 7, SimpleDateFormat's YYYY might not handle week-based years correctly");
    }

    private static void demonstrateModernStyle() {
        // Create a LocalDate for December 30, 2024
        LocalDate date = LocalDate.of(2024, 12, 30);

        // yyyy - Calendar year
        DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("yyyy format: " + date.format(formatterYear));

        // YYYY - Week-based year
        DateTimeFormatter formatterWeekYear = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println("YYYY format: " + date.format(formatterWeekYear));

        System.out.println("Note: In Java 8+, YYYY correctly handles week-based years");
        System.out.println("- yyyy represents the calendar year");
        System.out.println("- YYYY represents the week-based year (ISO week date)");
        System.out.println("  December 30, 2024 falls in the first week of 2025,");
        System.out.println("  hence YYYY shows 2025 instead of 2024");
    }
}

