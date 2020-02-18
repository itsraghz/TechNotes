import java.util.function.Predicate;

/**
 * <p>A sample Java program to demonstrate the Java 8 Funtional Interface - Predicate
 *    in a traditinoal, non-lambda style of execution using an Anonymous Inner Class.
 * <p>
 *
 * @author raghs (Raghavan alias Saravanan Muthu)
 */
public class Java8PredicateNonLambdaExample
{
	public static void main(String... args)
	{
		Predicate<String> strLen = new Predicate<String>(){
			@Override
			public boolean test(String value) {
				System.out.println("[Java8PredicateExample-AnonymousInnerClass] Input : [" + value + "], length : [" + value.length() +"]");
				return value.length() < 10;
			}
		};
		System.out.println(strLen.test("Apples") + " - Apples are less than 10 characters");
		System.out.println(strLen.test("Pomegranate") + " - Pomegranate is NOT less than 10 characters");
	}
}
