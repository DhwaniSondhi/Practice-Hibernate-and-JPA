package org.practice.hibernate.HiberDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

//POJO
@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private String color;
	
	public Person(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public static class PersonBuilder{
		private int id;
		private String name;
		private String color;
		
		public PersonBuilder setId(int id) {
			this.id = id;
			return this;
		}
		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public PersonBuilder setColor(String color) {
			this.color = color;
			return this;
		}
		public Person build() {
			return new Person(id, name, color);
		}
	}
}
