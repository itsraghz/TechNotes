import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class SimpleDateFormatExample
{
    public static void main(String... args)
    {
        System.out.println("SimpleDateFormatExample - main()");
        String dateInStr = "2023-06-17";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObj = null;
        try {
            dateObj = sdf.parse(dateInStr);
        } catch(ParseException parseException) {
            System.err.println("ParseException occurred while parsing a String to a Date");
            System.err.println("Error Message : " + parseException.getMessage());
        }

        System.out.println("Input - Date in String : " + dateInStr);
        System.out.println("Output - Date Object parsed : " + dateObj);
    }
}
