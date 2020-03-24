import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee
{
	private String name;
	private int age;
	private char gender;
}
