package org.practice.hibernate.HiberDemo;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
	
	private String first;
	private String middle;
	private String last;
	
	public Name() {}
	public Name(String first, String middle, String last) {
		super();
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
	@Override
	public String toString() {
		return "Name [first=" + first + ", middle=" + middle + ", last=" + last + "]";
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getMiddle() {
		return middle;
	}
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
}
