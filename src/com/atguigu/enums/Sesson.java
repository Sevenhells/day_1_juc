package com.atguigu.enums;

public enum Sesson {
	ONE(1,"Spring"),TWO(2,"Summer"),THREE(3,"Autumn"),FOUR(4,"Winner");
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
	private Sesson(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	public static Sesson forEachSessonEnums(Integer index){
		for(Sesson se:values()){
			if(se.retCode==index){
				return se;
			}
		}
		return null;
	}
	
}
