package com.uhcl_system;

public class Faculty extends User {
	@Override
	void viewMyCourses() {
		for (Course c : getCourses()) {
				System.out.println(c.getCourseID());
				for(User u:c.getStudents()) {
				System.out.println("Students enrolled: " + u.getName());
				System.out.println();
				}
		}
	}

	public Faculty(String name, String major, String login, String password) {
		super(name, major, login, password);

	}

}
