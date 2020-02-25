/**
 *  <p>
 *  A Java program to demonstrate the Enum datatype added in Java SE 5, and the various
 *  different ways to operate/manipulate the enums.
 *  </p>
 *
 *  <p>
 * 	<b>URL :</b> http://tutorials.jenkov.com/java/enums.html 
 *  </p>
 *  
 *  @author raghs (Raghavan alias Saravanan Muthu)
 */
enum Level
{
	HIGH (3),     // calls constructor with the value 3
	MEDIUM (2),   // calls constructor with the value 2
	LOW (1)       // calls constructor with the value 1
	;             // semicolon needed when fields/method follow

	private final int levelCode;

	Level(int levelCode) {
		this.levelCode = levelCode;
	}

	public int getLevelCode() {
		return this.levelCode;
	}
}

public class JavaEnumDemo
{	
	public static void main(String... args)
	{
		System.out.println("======================================");
		System.out.println("		Java Enum Demo		  ");
		System.out.println("======================================");

		Level level = Level.HIGH;
		System.out.println("Enum of type HIGH : " + level);

		System.out.println("Level Code of type HIGH : " + level.getLevelCode());

		System.out.println("--------------------------------------");
	}
}

