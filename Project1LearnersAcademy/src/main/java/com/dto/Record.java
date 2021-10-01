package com.dto;

public class Record {
	private String Var1;
	private String Var2;
	private String Var3;
	private String var4;
	private String var5;
	private String var6;
	
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
	public String getVar4() {
		return var4;
	}
	public void setVar4(String var4) {
		this.var4 = var4;
	}
	public String getVar5() {
		return var5;
	}
	public void setVar5(String var5) {
		this.var5 = var5;
	}
	public String getVar6() {
		return var6;
	}
	public void setVar6(String var6) {
		this.var6 = var6;
	}
	
	@Override
	public String toString() {
		return "Record [Var1=" + Var1 + ", Var2=" + Var2 + ", Var3=" + Var3 + ", var4=" + var4 + ", var5=" + var5 + ", var6=" + var6 + "]";
	}
}
