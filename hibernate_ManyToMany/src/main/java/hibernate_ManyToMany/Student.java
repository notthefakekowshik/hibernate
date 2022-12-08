package hibernate_ManyToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="students")
	private List<Laptop> laptops = new ArrayList<Laptop>();
	
	public List<Laptop> getLaptops() {
		return laptops;
	}
	
	public void setLaptops(List<Laptop> laptop) {
		this.laptops = laptop;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


