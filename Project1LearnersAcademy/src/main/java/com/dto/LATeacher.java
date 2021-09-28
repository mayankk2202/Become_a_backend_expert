package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class LATeacher {
	@Id
	@Column(name = "TEACHER_ID")
	private String tID;
	@Column(name = "FIRST_NAME")
	private String fname;
	@Column(name = "LAST_NAME")
	private String lname;
	public String gettID() {
		return tID;
	}
	public void setTID(String tid) {
		this.tID = tid;
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
