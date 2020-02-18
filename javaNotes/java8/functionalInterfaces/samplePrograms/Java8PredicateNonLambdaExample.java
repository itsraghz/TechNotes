import java.util.function.Predicate;

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
