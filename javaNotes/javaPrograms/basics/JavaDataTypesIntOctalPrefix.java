/**
 *  <p>
 *  	A Java program to desmontrate the values to an integer primitive can have a prefix of 
 * 	other base (binary, octal, hexadecimal).The same can be used for the other numeric primitive
 *	data types like byte, short, long as well.
 *  </p>
 *  <p>
 *	An integer value can be assigned to an int variable with a prefix 'O' (for Octal base - Base 8).
 *      <b>Reference URL of Java 8 JLS </b> : https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.1 
 *  </p>
 *  <p>
 *	<ul>
 *		<li>0b/0B prefix - for a binary value (within its range for binary -  0 or 1)</li>
 *		<li>0 prefix - for an octal value (within the octal range of values - 0 to 7</li>
 *		<li>0x/0X prefix - for a hexa value (within the hexadecimal value range - [0-9,A-F,a-f]</li>
 *	</ul>
 *  </p>
 *  <p>
 *	<b>Other Reference URLs:</b>
 *	<ul>
 *		<li>https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html</li>
 *		<li>https://riptutorial.com/java/example/6654/hexadecimal--octal-and-binary-literals</li>
 *		<li>https://www.codejava.net/java-core/the-java-language/notes-about-numeric-literals-in-java</li>
 *		<li>http://java.boot.by/ocpjp7-upgrade/ch01s02.html</li>
 *	</ul>
 *  </p>
 *  
 *  @author raghs (Raghavan alias Saravanan Muthu)
 */
public class JavaDataTypesIntOctalPrefix 
{
	public static void main(String... args)
	{
		int i = 013;

		System.out.println("integer value 13 with an octal prefix is : " + i);
	}
}

