import java.util.function.Predicate;

public class Java8PredicateExample
{
	public static void main(String... args)
	{
		Predicate<String> strLen = (s) -> s.length() < 10;
		System.out.println(strLen.test("Apples") + " - Apples are less than 10 characters");
		System.out.println(strLen.test("Pomegranate") + " - Pomegranate is NOT less than 10 characters");
	}
}
