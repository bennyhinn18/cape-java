package com.cistron.app.student.model;

public class Department {

	public Department(){
	 //Initialize	
	}	

	int id;
	String name;
	String hodName;
	College college;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String gethodName() {
		return hodName;
	}

	public void setHODName(String hodName) {
		this.hodName = hodName;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}	
	
}

