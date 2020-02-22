import java.util.function.Function;

/**
 * <p>A sample Java program to demonstrate the Java 8 Funtional Interface - Function
 *    in a lambda style of execution.
 * <p>
 *
 * @author raghs (Raghavan alias Saravanan Muthu)
 */
public class Java8FunctionExample
{
	public static void main(String... args)
	{
		Function<Integer, String> converter = (num) -> Integer.toString(num);
		
		// apply is the 'functional' interface of Function Interface (SAM Method)
		System.out.println("Length of 26 is : " + converter.apply(26).length());

	}
}
