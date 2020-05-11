package org.practice.hibernate.HiberDemo.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//POJO
@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private int marks;
	@ManyToMany(mappedBy="st")
	private List<Laptop> laptop;
	
	public Student() {}
	public Student(int rollno, String name, int marks, List<Laptop> laptop) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.laptop=laptop;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}


	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public static class StudentBuilder{
		private int rollno;
		private String name;
		private int marks;
		private List<Laptop> laptop;
		
		public StudentBuilder setRollno(int rollno) {
			this.rollno = rollno;
			return this;
		}
		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public StudentBuilder setMarks(int marks) {
			this.marks = marks;
			return this;
		}
		public StudentBuilder setLaptop(List<Laptop> laptop) {
			this.laptop = laptop;
			return this;
			
		}
		public Student build() {
			return new Student(rollno, name, marks,laptop);
		}
		
	}
}
