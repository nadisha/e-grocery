package com.technoura.grocery.domain.enums;

public enum UserType {
	CUSTOMER, ADMIN, DRIVER;
	
	public String authority() {
		return "ROLE_" + this.name();
	}	
}
