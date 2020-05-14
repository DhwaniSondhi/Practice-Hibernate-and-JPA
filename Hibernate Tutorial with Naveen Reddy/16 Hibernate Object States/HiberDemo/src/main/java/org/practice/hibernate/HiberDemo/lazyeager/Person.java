package org.practice.hibernate.HiberDemo.lazyeager;

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

//POJO
@Entity

public class Person {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="person", fetch=FetchType.EAGER)
	private List<Laptop> laptops;
	
	public Person() {
		laptops=new ArrayList<Laptop>();
	}
	public Person(int id, String name, List<Laptop> laptops) {
		super();
		this.id = id;
		this.name = name;
		this.laptops=laptops;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
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
	
	public static class PersonBuilder{
		private int id;
		private String name;
		private List<Laptop> laptops;
		
		public PersonBuilder setId(int id) {
			this.id = id;
			return this;
		}
		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public PersonBuilder setLaptops(List<Laptop> laptops) {
			this.laptops = laptops;
			return this;
		}
		public Person build() {
			return new Person(id, name, laptops);
		}
	}
}
