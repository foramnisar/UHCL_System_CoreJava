package com.uhcl_system;

import java.util.ArrayList;

abstract class User {
	private String name;
	private String major;
	private String login;
	private String password;
	
	// constructor
	public User(String name, String major, String login, String password) {
		super();
		this.name = name;
		this.major = major;
		this.login = login;
		this.password = password;
	}

	// abstract method
	
	abstract void viewMyCourses();

	// getter and setter methods.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private ArrayList<Course> courses = new ArrayList<>();

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

}
