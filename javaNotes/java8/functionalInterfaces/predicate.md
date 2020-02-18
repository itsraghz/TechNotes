# Predicate - Functional Interface

## Definition

	An interface to test a value based on a test/condition and returns a boolean value

## Syntax/Example

	//declare the interface with the right package
	import java.util.function.Predicate;

	Predicate<String> strLen = (s) -> s.length() < 10;
	System.out.println(strLen.test("Apples") + " - Apples are less than 10 characters in length");

## Explanation

	Declare the Predicate of a particular type - here we did on a String type, meaning that the Predicate will be used for a String value.
	Write/Implement the test() method using a Lambda (or you can use the typical old style Anonymous Inner class to override the test() method)
	Use / Invoke the 'test' method on the predicate instance
	The return value from the Predicate Interface's test() method will be a boolean - true/false. 

## Sample Program

	`import java.util.function.Predicate;

	public class Java8PredicateExample
	{
		public static void main(String... args)
		{
			Predicate<String> strLen = (s) -> s.length() < 10;
			System.out.println(strLen.test("Apples") + " - Apples are less than 10 characters");
			System.out.println(strLen.test("Pomegranate") + " - Pomegranate is NOT less than 10 characters");
		}
	}`

## Output

	`$ java Java8PredicateExample
	true - Apples are less than 10 characters
	false - Pomegranate is NOT less than 10 characters`

## Notes

	See the 'samplePrograms' directory for the invocation of same example via an Anonymous Inner class - the typical Java 7 styel.
	Also the output of the programs are available in the text file inside a subdirectory called 'output' inside the 'samplePrograms' directory.

