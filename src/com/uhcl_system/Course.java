package com.uhcl_system;

import java.util.ArrayList;

public class Course {
	private String courseID;
	private String instructor; // use name of Instructor
	private String major;
	private int capacity = 1; // default
	private int enrolled = 0; // default
	private String status = "open"; // default

	private ArrayList<User> students = new ArrayList<>();
	private ArrayList<ClassNote> notes = new ArrayList<>();

	public void viewCourseNotes() {
		System.out.println();
		if (notes.size() > 0) {
			for (ClassNote cn : notes) {
				System.out.println(cn.getDate() + " : " + cn.getNote());
			}
		} else {
			System.out.println("None");
			System.out.println();
		}
	}

	// constructor
	public Course(String courseID, String instructor, String major) {
		super();
		this.courseID = courseID;
		this.instructor = instructor;
		this.major = major;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<User> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<User> students) {
		this.students = students;
	}

	public ArrayList<ClassNote> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<ClassNote> notes) {
		this.notes = notes;
	}

}
