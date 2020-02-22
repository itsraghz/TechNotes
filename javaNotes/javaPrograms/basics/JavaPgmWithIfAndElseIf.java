/**
 *  <p>
 *  	A Java program to check that if a program can have only if and else-if without the 
 *  	completing else block, which is perfectly fine.
 *  </p>
 *  <p>
 *	A Java program does not really expect or insists an 'else' block at the end.
 *  </p>
 *  
 *  @author raghs (Raghavan alias Saravanan Muthu)
 */
public class JavaPgmWithIfAndElseIf 
{
	public static void main(String... args)
	{
		int i = 4;

		if(i>5) {
			System.out.println("If statement..");
		} else if (i % 2 ==0) {
			System.out.println("else-if statement...");
		}
	}
}

