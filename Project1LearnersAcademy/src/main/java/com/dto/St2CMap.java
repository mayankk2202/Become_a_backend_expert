package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ST2CMAP")
public class St2CMap {
	@Id
	@Column(name = "ST2CMAP_CODE")
	private String code;
	@Column(name = "ROLL_NUMBER")
	private String rono;
	@Column(name = "CLASS_CODE")
	private String clc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRono() {
		return rono;
	}
	public void setRono(String rono) {
		this.rono = rono;
	}
	public String getClc() {
		return clc;
	}
	public void setClc(String clc) {
		this.clc = clc;
	}
}
