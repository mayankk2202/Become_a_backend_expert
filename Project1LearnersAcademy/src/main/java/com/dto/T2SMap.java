package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T2SMAP")
public class T2SMap {
	@Id
	@Column(name = "T2SU_CODE")
	private String code;
	@Column(name = "TEACHER_CODE")
	private String tec;
	@Column(name = "SUBJECT_CODE")
	private String suc;
	
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
	public String getSuc() {
		return suc;
	}
	public void setSuc(String suc) {
		this.suc = suc;
	}
}
