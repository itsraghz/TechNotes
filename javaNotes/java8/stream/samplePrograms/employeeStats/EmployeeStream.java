import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeStream
{
	public static void main(String... args)
	{
		ArrayList<Employee> empList = new ArrayList<>();

		fillTheList(empList);

		printMsg("Printing each employees via Stream " );
		empList.stream()
		       .forEach(e -> System.out.println(e));

		printMsg("Printing the age of all employees ");
		printTotalAge(empList);
		
		printMsg("Printing the age of all male employees ");
		printTotalAgeOfMale(empList);
		
		printMsg("Printing the age of all female employees ");
		printTotalAgeOfPredicate(empList, isFemalePredicate(), "All female");
	}

	static Predicate<Employee> isFemalePredicate() {
		return e-> e.getGender()=='F';
	}

	static void printMsg(String msg)
	{
		System.out.println();
		System.out.println("=======================================");
		System.out.println("   " + msg + ": " );
		System.out.println("=======================================");
	}

	public static void fillTheList(ArrayList<Employee> empList)
	{
		empList.add(new Employee("Raghavan Muthu",38, 'M')); 
		empList.add(new Employee("Kannann",39, 'M')); 
		empList.add(new Employee("Meenakshi",32, 'F')); 
		empList.add(new Employee("Karthick Muthu",7, 'M')); 
		empList.add(new Employee("Karthiga Karpagam",7, 'F')); 
		empList.add(new Employee("Murugappan", 58, 'M'));
	}

	static void printTotalAge(ArrayList<Employee> empList) 
	{
		int total = empList.stream()
				   .map(e -> e.getAge())
				   .reduce(0, Integer::sum);

		System.out.println("Age of all employees : " + total);
	}

	static void printTotalAgeOfMale(ArrayList<Employee> empList)
	{

		int total = empList.stream()
				   .filter(e -> e.getGender()=='M')
				   .map(e -> e.getAge())
				   .reduce(0, Integer::sum);

		System.out.println("Age of all Male employees : " + total);
	}

	static void printTotalAgeOfPredicate(ArrayList<Employee> empList, Predicate<Employee> predicate, String predicateName)
	{
		int total = empList.stream()
				   .filter(predicate)
				   .map(e -> e.getAge())
				   .reduce(0, Integer::sum);

		System.out.println("Age of all employees matching with the Predicate [ " + predicateName + "] is : " + total);
	}
}
