package hibernate_OneToOne;

import jakarta.persistence.*;

@Entity
public class Laptop {

	@Id
	private int laptopId;
	private String laptopName;
	
	@OneToOne
	private Student stu;

	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
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