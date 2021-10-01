package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SU2CMAP")
public class Su2CMap {
	@Id
	@Column(name = "SU2C_CODE")
	private String code;
	@Column(name = "SUBJECT_CODE")
	private String suc;
	@Column(name = "CLASS_CODE")
	private String clc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSuc() {
		return suc;
	}
	public void setSuc(String suc) {
		this.suc = suc;
	}
	public String getClc() {
		return clc;
	}
	public void setClc(String clc) {
		this.clc = clc;
	}
}
