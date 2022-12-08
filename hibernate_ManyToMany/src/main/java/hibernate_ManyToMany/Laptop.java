package hibernate_ManyToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Laptop {

	@Id
	private int laptopId;
	private String laptopName;
	
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();


	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	
}