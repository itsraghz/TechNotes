/**
 *  <p>
 *  A Java program to demonstrate the printing of the status and the list of arguments entered
 *  in the Command Line during the invocation.
 *  </p>
 *  
 *  @author raghs (Raghavan alias Saravanan Muthu)
 */
public class CommandLineArgsPrint
{
	public static void main(String... args)
	{
		if(args.length <=0 ) {
			System.err.println("You have not entered any arguments on the Command Line");
			System.out.println("Usage : java CommandLineArgsPrint <arguments-separated-by-space>");
			return ;
		}
		
		System.out.println("Command Line Arguments entered are : ");
		
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("Args[" + i + "] : " + args[i]);
		}
	
		System.out.println("-------------------------------------------------------------");	
		System.out.println(" [#] Total number of arguments entered are :: " + args.length);
		System.out.println("-------------------------------------------------------------");	
	}
}
