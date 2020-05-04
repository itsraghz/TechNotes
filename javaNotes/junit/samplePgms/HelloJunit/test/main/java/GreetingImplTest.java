import org.junit.Test;
import static org.junit.Assert.*;
//import GreetingImpl;

/**
 * JUnit4 Test Class for GreetingImpl
 *
 * @author raghs
 */
public class GreetingImplTest
{
	@Test
	public void testGreet()
	{
		String result = new GreetingImpl().greet("JUnit");
		assertNotNull(result);
		assertEquals("Hello JUnit", result);
	}
}
