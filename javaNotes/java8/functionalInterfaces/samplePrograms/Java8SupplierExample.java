import java.util.function.Supplier;

/**
 * <p>A sample Java program to demonstrate the Java 8 Funtional Interface - Supplier 
 *    in a lambda style of execution.
 * <p>
 *
 * @author raghs (Raghavan alias Saravanan Muthu)
 */
public class Java8SupplierExample
{
	public static void main(String... argsi)
	{
		Supplier<String> s = () -> ("Java 8 is really fun, when it is SUPPLIED well!");
		
		// get is the 'functional' method of Supplier Interface (SAM Method)
		// The return type is void(). It does not take any arguments as well.  
		System.out.println(s.get());
	}
}
