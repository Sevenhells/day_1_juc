package com.atguigu.enums;

public enum CountryEnums {
	 ONE(1,"韩"),TWO(2,"魏"),THREE(3,"赵"),FOUR(4,"齐"),FIVE(5,"楚"),SIX(6,"燕");
	private Integer retCode;
	private String retMsg;
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	private CountryEnums(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	public static CountryEnums forEachCountryEnums(Integer index){
		for(CountryEnums elEnums:values()){
			if(elEnums.retCode==index){
				return elEnums;
			}
		}
		return null;
	}
	
}
