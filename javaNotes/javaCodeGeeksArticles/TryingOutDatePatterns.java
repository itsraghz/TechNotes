import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class TryingOutDatePatterns
{
	public static void main(String... args)
	{
		String[] dateArray = new String[]{"2023-07-11", "2023-Jul-11"};
		String[] patternArray = new String[]{"yyyy-MM-dd", "yyyy-MMM-dd"};
		SimpleDateFormat sdf = null;
		Date dateObj = null;
		
		for(int i=0; i < dateArray.length; i++) 
		{
			System.out.println("Date : " + dateArray[i] + " | pattern : " + patternArray[i]);
			sdf = new SimpleDateFormat(patternArray[i]);		
			
			try {
				dateObj = sdf.parse(dateArray[i]);
			}catch(ParseException parseException) {
				System.err.println("Exception occurred while parsing a Date from String");
				System.err.println("Error Message : " + parseException.getMessage());
			}
			System.out.println("Date Object parsed with the pattern [" + patternArray[i] + "] : " + dateObj);
		}
	}
}
