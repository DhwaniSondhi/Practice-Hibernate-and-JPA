package org.practice.hibernate.HiberDemo.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

//POJO
@Entity
public class Laptop {

	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<Student> st;
	
	public Laptop() {
		st=new ArrayList<Student>();
	}
	public Laptop(int id, String name, List<Student> st) {
		super();
		this.id = id;
		this.name = name;
		this.st=st;
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
	public List<Student> getSt() {
		return st;
	}
	public void setSt(List<Student> st) {
		this.st = st;
	}
	public static class LaptopBuilder{
		private int id;
		private String name;
		private List<Student> st;
		public LaptopBuilder setId(int id) {
			this.id = id;
			return this;
		}
		public LaptopBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public void setSt(List<Student> st) {
			this.st = st;
		}
		public Laptop build() {
			return new Laptop(id, name,st);
		}
	}
}
