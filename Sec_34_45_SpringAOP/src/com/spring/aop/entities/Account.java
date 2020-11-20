package com.spring.aop.entities;

public class Account {

	private String name, level;

	public Account() {}

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getLevel() {return level;}

	public void setLevel(String level) {this.level = level;}
	
	@Override
	public String toString() {
		return "\n\t+ Account name: " + name + " & level: " + level;
	}
	
}
