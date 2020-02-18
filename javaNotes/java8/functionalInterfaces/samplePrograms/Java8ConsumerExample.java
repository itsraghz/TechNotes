import java.util.function.Consumer;

/**
 * <p>A sample Java program to demonstrate the Java 8 Funtional Interface - Consumer
 *    in a lambda style of execution.
 * <p>
 *
 * @author raghs (Raghavan alias Saravanan Muthu)
 */
public class Java8ConsumerExample
{
	public static void main(String... args)
	{
		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		
		// accept is the 'functional' interface of Consumer Interface (SAM Method)
		// The return type is void().The method implementation itself prints the message in console. 
		consumerStr.accept("Java 8 is Really Awesome!");
	}
}
