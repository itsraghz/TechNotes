import java.util.function.Predicate;

/**
 * <p>A sample Java program to demonstrate the Java 8 Funtional Interface - Predicate
 *    in a lambda style of execution.
 * <p>
 *
 * @author raghs (Raghavan alias Saravanan Muthu)
 */
public class Java8PredicateExample
{
	public static void main(String... args)
	{
		Predicate<String> strLen = (s) -> s.length() < 10;
		System.out.println(strLen.test("Apples") + " - Apples are less than 10 characters");
		System.out.println(strLen.test("Pomegranate") + " - Pomegranate is NOT less than 10 characters");
	}
}
