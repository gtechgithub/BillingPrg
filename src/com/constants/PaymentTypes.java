package com.constants;

public enum PaymentTypes {

	PAYMENT("PAYMENT"), REVERSAL("REVERSAL");

	PaymentTypes(String desc) {
		description = desc;
	}

	private String description;

	public String getDescription() {
		return this.description;
	}
	
	 public static PaymentTypes getByName(String name){
		    return   PaymentTypes.valueOf(name);
		}
}
