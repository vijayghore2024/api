package com.example.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int rno;
	private String name;
	private String dob;
	private String city;
	
	public Student() {
		super();
	}

	public Student(int rno, String name, String dob, String city) {
		super();
		this.rno = rno;
		this.name = name;
		this.dob = dob;
		this.city = city;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", dob=" + dob + ", city=" + city + "]";
	}
}
