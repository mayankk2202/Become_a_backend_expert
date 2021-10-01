package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ST2SUMAP")
public class St2SuMap {
	@Id
	@Column(name = "ST2SUMAP_CODE")
	private String code;
	@Column(name = "ROLL_NUMBER")
	private String rono;
	@Column(name = "SUBJECT_CODE")
	private String suc;
	
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
	public String getSuc() {
		return suc;
	}
	public void setSuc(String suc) {
		this.suc = suc;
	}
}
