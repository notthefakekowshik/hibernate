package hibernateKav;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Employee {
	@Id
	private int id;
	private String name;
	private int age;
}
