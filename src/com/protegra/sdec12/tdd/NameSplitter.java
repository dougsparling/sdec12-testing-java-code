package com.protegra.sdec12.tdd;

public final class NameSplitter {
	
	private String name;

	public NameSplitter(String name) {
		this.name = name;
	}
	
	public final String getFirstName() {
		return name.split(" ")[0];
	}
	
	public final String getLastName() {
		return name.split(" ")[1];
	}
}
