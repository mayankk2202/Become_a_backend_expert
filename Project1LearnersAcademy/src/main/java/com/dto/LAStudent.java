package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class LAStudent {
	@Id
	@Column(name = "ROLL_NUMBER")
	private String rono;
	@Column(name = "FIRST_NAME")
	private String fname;
	@Column(name = "LAST_NAME")
	private String lname;
	public String getRono() {
		return rono;
	}
	public void setRono(String rono) {
		this.rono = rono;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
}
