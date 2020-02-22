/**
 *  <p>
 *  A Java program to demonstrate the feasibility to chain / nest the ternary 
 *  operators in a single execuable statement.
 *  </p>
 *
 *  <p>
 * 	<b>URL :</b> http://tutorials.jenkov.com/java/ternary-operator.html
 *  </p>
 *  
 *  @author raghs (Raghavan alias Saravanan Muthu)
 */
public class ChainedTernaryOperatorDemo
{
	public static void main(String... args)
	{
		int x = 4, y = 3, z = 4;
		System.out.println("[INFO] Value of X : " + x + ", Y : " + y + ", Z is : " + z);
		System.out.println("[Simple] -> " + (x > y ? "X is greater than Y" : "Y is greater than X"));
		System.out.println("[Nested] -> " + (x > y ? x > z ? "X is greater than Y and Z" : "X is greater than Y but lesser than or equal to Z" : "X is lesser than Y"));
	}
}
