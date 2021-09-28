package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS")
public class LAClass {
	@Id
	@Column(name = "CLASS_CODE")
	private String classcode;
	@Column(name = "CLASS_NAME")
	private String classname;
	@Column(name = "CLASS_DESCRIPTION")
	private String cldesc;
	
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String string) {
		this.classcode = string;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getCldesc() {
		return cldesc;
	}
	public void setCldesc(String cldesc) {
		this.cldesc = cldesc;
	}
}
