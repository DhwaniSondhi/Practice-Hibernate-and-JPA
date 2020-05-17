package org.practice.hibernate.HiberDemo.hql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.practice.hibernate.HiberDemo.lazyeager.Laptop;

//POJO
@Entity
public class Student {

	@Id
	private int id;
	private String name;
	private int marks;
	public Student() {}
	public Student(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks=marks;
	}
	
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}


	public static class StudentBuilder{
		private int id;
		private String name;
		private int marks;
		
		public StudentBuilder setId(int id) {
			this.id = id;
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
		public Student build() {
			return new Student(id, name, marks);
		}
	}
}
