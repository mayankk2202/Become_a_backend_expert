package com.dto;

public class Record {
	private String Var1;
	private String Var2;
	private String Var3;
	public String getVar1() {
		return Var1;
	}
	public void setVar1(String var1) {
		Var1 = var1;
	}
	public String getVar2() {
		return Var2;
	}
	public void setVar2(String var2) {
		Var2 = var2;
	}
	public String getVar3() {
		return Var3;
	}
	public void setVar3(String var3) {
		Var3 = var3;
	}
	@Override
	public String toString() {
		return "Record [Var1=" + Var1 + ", Var2=" + Var2 + ", Var3=" + Var3 + "]";
	}
}
