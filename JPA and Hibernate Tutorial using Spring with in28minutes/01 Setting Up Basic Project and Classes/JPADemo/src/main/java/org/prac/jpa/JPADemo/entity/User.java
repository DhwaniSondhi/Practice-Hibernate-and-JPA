package org.prac.jpa.JPADemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	public User() {
		super();
	}
	public User(long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public static class UserBuilder{
		private long id;
		private String name;
		private String role;
		public UserBuilder setId(long id) {
			this.id = id;
			return this;
		}
		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public UserBuilder setRole(String role) {
			this.role = role;
			return this;
		}
		public User build() {
			return new User(id, name, role);
		}
	}
	
}
