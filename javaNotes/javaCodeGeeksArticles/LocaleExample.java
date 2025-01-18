import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LocaleExample {
    public static void main(String[] args) {
        // Date string to parse
        String dateString = "2023-06-14 13:45:30";

        // Parse the date string using the default locale
        try {
            SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = defaultFormat.parse(dateString);

            // Format the parsed date using different locales
            SimpleDateFormat usFormat = new SimpleDateFormat("MMMM dd, yyyy - HH:mm:ss", Locale.US);
            String formattedDateUS = usFormat.format(date);
            System.out.println("Formatted Date (US): " + formattedDateUS);

            SimpleDateFormat germanFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss", Locale.GERMANY);
            String formattedDateGerman = germanFormat.format(date);
            System.out.println("Formatted Date (Germany): " + formattedDateGerman);

            SimpleDateFormat frenchFormat = new SimpleDateFormat("dd MMMM yyyy - HH:mm:ss", Locale.FRANCE);
            String formattedDateFrench = frenchFormat.format(date);
            System.out.println("Formatted Date (France): " + formattedDateFrench);
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + dateString);
            e.printStackTrace();
        }
    }
}
