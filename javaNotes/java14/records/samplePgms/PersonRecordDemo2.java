public class PersonRecordDemo2
{
	public static void main(String... args)
	{
		// Instantiating a Person record using the `new` keyword, as that of a `class`.
		Person raghs = new Person("Raghavan", 42);

		// Printing a Record, which will invoke the `toString()` method!
		System.out.println("1st Person record created :: " + raghs);
		System.out.println("1st Person record (raghs) Hashcode :: " + raghs.hashCode());
		
		Person raghs2 = new Person("Raghavan", 42);
		Person kanna = new Person("Kannan", 43);

		System.out.println("2nd Person created (raghs2) :: " + raghs2);
		System.out.println("2nd Person created (raghs2) Hashcode :: " + raghs2.hashCode());
		System.out.println("3rd Person created (kanna) :: " + kanna);
		System.out.println("3rd Person created (kanna) Hashcode :: " + kanna.hashCode());

		System.out.println("raghs==raghs2 ? " + (raghs==raghs2));
		System.out.println("raghs.equals(raghs2) ? " + raghs.equals(raghs2));

		System.out.println("raghs==kanna ? " + (raghs==kanna));
		System.out.println("raghs.equals(kanna) ? " + raghs.equals(kanna));
	}
}
