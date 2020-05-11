package org.practice.hibernate.HiberDemo.lazyeager;

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
	private String brandName;
	private int price;
	@ManyToOne
	private Person person;
	
	public Laptop() {}
	public Laptop(int id, String brandName, int price, Person person) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.price=price;
		this.person=person;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public static class LaptopBuilder{
		private int id;
		private String brandName;
		private int price;
		private Person person;
		public LaptopBuilder setPerson(Person person) {
			this.person = person;
			return this;
		}
		public LaptopBuilder setId(int id) {
			this.id = id;
			return this;
		}
		public LaptopBuilder setBrandName(String brandName) {
			this.brandName = brandName;
			return this;
		}
		public LaptopBuilder setPrice(int price) {
			this.price = price;
			return this;
		}
		public Laptop build() {
			return new Laptop(id, brandName, price, person);
		}
	}
}
