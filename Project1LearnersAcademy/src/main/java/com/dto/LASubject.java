package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class LASubject {
	@Id
	@Column(name = "SUB_CODE")
	private String sucode;
	@Column(name = "SUBJECT")
	private String sub;
	@Column(name = "SUBJECT_DES")
	private String suDes;
	public String getSucode() {
		return sucode;
	}
	public void setSucode(String sucode) {
		this.sucode = sucode;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getSuDes() {
		return suDes;
	}
	public void setSuDes(String suDes) {
		this.suDes = suDes;
	}
}
