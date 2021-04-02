package com.uhcl_system;

public class Student extends User {

	@Override
	void viewMyCourses() {
		if (getCourses().size() > 0) {
			for (Course c : getCourses()) {

				System.out.println(c.getCourseID() + ", Instructor:" + c.getInstructor());
			}
		} else {
			System.out.println("You do not have any course registered!");
		}
	}

	public Student(String name, String major, String login, String password) {
		super(name, major, login, password);

	}

}
