public class PersonRecordDemo1
{
	public static void main(String... args)
	{
		// Instantiating a Person record using the `new` keyword, as that of a `class`.
		Person raghs = new Person("Raghavan", 42);

		// Printing a Record, which will invoke the `toString()` method!
		System.out.println("Person record created :: " + raghs);
		
		// Printing a Record, by explicitly invoking the `toString()` method!
		System.out.println("Person record - explicit toString() :: " + raghs.toString());
		
		// Printing the hashCode of a Record
		System.out.println("Person record - HashCode :: " + raghs.hashCode());
	
		// See the magic, and difference. We now have the getter methods matching with just the name of the property
		// , but without the prefix 'get' (usual JavaBean / POJO way), for each of the attributes defined in the `record`!
		System.out.println("Person Name : " + raghs.name());
		System.out.println("Person Age  : " + raghs.age());
	}
}
