package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T2CMAP")
public class T2CMap {
	@Id
	@Column(name = "T2C_CODE")
	private String code;
	@Column(name = "TEACHER_CODE")
	private String tec;
	@Column(name = "CLASS_CODE")
	private String clc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTec() {
		return tec;
	}
	public void setTec(String tec) {
		this.tec = tec;
	}
	public String getClc() {
		return clc;
	}
	public void setClc(String clc) {
		this.clc = clc;
	}
}
