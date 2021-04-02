package com.uhcl_system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UHCL_System {

	// ArrayLists
	public static ArrayList<Course> allCourses = new ArrayList<>();
	public static ArrayList<User> allUsers = new ArrayList<>();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// hard coding to create the 4 courses object

		Course isam5638 = new Course("ISAM 5638", "Dr. Lin", "MIS");
		Course isam5735 = new Course("ISAM 5735", "Dr. Lin", "MIS");
		Course isam5331 = new Course("ISAM 5331", "Dr. Saleem", "MIS");
		Course acct6200 = new Course("ACCT 6200", "Dr. Lehmann", "Accounting");

		allCourses.add(isam5638);
		allCourses.add(isam5735);
		allCourses.add(isam5331);
		allCourses.add(acct6200);

		// hard coding to create the 4 students and 3 faculty object

		Faculty lin = new Faculty("Dr. Lin", "MIS", "lin", "1234");
		Faculty saleem = new Faculty("Dr. Saleem", "MIS", "saleem", "1234");
		Faculty lehmann = new Faculty("Dr. Lehmann", "Accounting", "lehmann", "1234");

		Student jean = new Student("Jean", "MIS", "jean", "4321");
		Student jack = new Student("Jack", "Accounting", "jack", "4321");
		Student mike = new Student("Mike", "MIS", "mike", "4321");
		Student joan = new Student("Joan", "MIS", "joan", "4321");

		allUsers.add(lin);
		allUsers.add(saleem);
		allUsers.add(lehmann);

		allUsers.add(jean);
		allUsers.add(jack);
		allUsers.add(mike);
		allUsers.add(joan);

		// add the course to the faculty who teaches it
		lin.getCourses().add(isam5638);
		lin.getCourses().add(isam5735);
		saleem.getCourses().add(isam5331);
		lehmann.getCourses().add(acct6200);

		// Welcome page
		do {
			System.out.println();
			System.out.println("Go Hawks!");
			System.out.println("1: e-Service");
			System.out.println("2: Blackboard");
			System.out.println("x: Leave");
			String goTo = input.nextLine();
			if (goTo.equals("1")) {
				String userID = UHCL_System.loginIdPass();
				do {
					if (allUsers.stream().anyMatch(
							x -> x.getLogin().equals(userID) && x.getClass().getSimpleName().equals("Faculty"))) {
						System.out.println();
						System.out.println("Welcome to UHCL eService!");
						System.out.println("v: view my courses");
						System.out.println("x: Logout");

					} else if (allUsers.stream().anyMatch(
							x -> x.getLogin().equals(userID) && x.getClass().getSimpleName().equals("Student"))) {
						System.out.println();
						System.out.println("Welcome to UHCL eService!");
						System.out.println("v: view my courses");
						System.out.println("r: register a course");
						System.out.println("x: Logout");
					}
					goTo = input.nextLine();
					String studentMajor;

					int i = 0;
					for (i = 0; i < allUsers.size(); i++) {
						if (allUsers.get(i).getLogin().equals(userID)) {
							break;
						}
					}

					if (goTo.equals("v")) {
						allUsers.get(i).viewMyCourses();
					} else if (goTo.equals("r")) {
						studentMajor = ((Student) allUsers.get(i)).getMajor();
						Course c = registerCourse(studentMajor, allUsers.get(i));
						if (c != null)
							allUsers.get(i).getCourses().add(c);

					} else if (goTo.equals("x")) {
						System.out.println("eService Logged out successfully!");
						break;
					} else {
						System.out.println("Please Enter Valid Input!");
					}
				} while (true);
			}

			// BB

			else if (goTo.equals("2")) {
				String userID = UHCL_System.loginIdPass();
				do {
					System.out.println();
					System.out.println("Welcome to UHCL Blackboard!");
					System.out.println("Select your course:");
					int i = 0;
					for (i = 0; i < allUsers.size(); i++) {
						if (allUsers.get(i).getLogin().equals(userID)) {
							break;
						}
					}
					List<Course> courses = allUsers.get(i).getCourses();
					int j = 1;
					for (Course c : courses) {
						System.out.println(j + ": " + c.getCourseID());
						j++;
					}
					System.out.println("x: leave Blackboard");
					goTo = input.nextLine();
					try {
						if (!goTo.equals("x") && Integer.parseInt(goTo) <= j) {

							do {

								String courseName = courses.get(Integer.parseInt(goTo) - 1).getCourseID();
								if (allUsers.stream().anyMatch(x -> x.getLogin().equals(userID)
										&& x.getClass().getSimpleName().equals("Faculty"))) {
									System.out.println();
									System.out.println("Please select your options for " + courseName + ":");
									System.out.println("v: view course notes");
									System.out.println("p: post new course note");
									System.out.println("x: leave the course");
								} else if (allUsers.stream().anyMatch(x -> x.getLogin().equals(userID)
										&& x.getClass().getSimpleName().equals("Student"))) {
									System.out.println();
									System.out.println("Please select your options for " + courseName + ":");
									System.out.println("v: view course notes");
									System.out.println("x: leave the course");
								}

								String bbNotes = input.nextLine();
								ClassNote classNote = new ClassNote();

								if (bbNotes.equals("v")) {
									System.out.print("Course notes of " + courseName + ":");
									courses.get(Integer.parseInt(goTo) - 1).viewCourseNotes();
								} else if (bbNotes.equals("p")) {

									classNote.postCourseNote();
									courses.get(Integer.parseInt(goTo) - 1).getNotes().add(classNote);

								} else if (bbNotes.equals("x")) {
									break;
								} else {
									System.out.println("Please Enter Valid Input!");
								}
							} while (true);
						}

						else if (goTo.equals("x")) {
							System.out.println("Blackboard Logged out successfully!");
							break;
						} else {
							System.out.println("Please Enter Valid Input!");
						}
					} catch (Exception e) {
						System.out.println("Please Enter Valid Input!");
					}
				} while (true);
			} else if (goTo.equals("x")) {
				System.out.println("Logged out successfully!");
				break;
			} else {
				System.out.println("Please Enter Valid Input!");
			}

		} while (true);
	}

	private static Course registerCourse(String studentMajor, User u) {

		HashSet<Course> userCourses = new HashSet<>(u.getCourses());
		List<Course> coursesMajor = new ArrayList<>();

		for (Course c : allCourses) {
			if (c.getMajor().equals(studentMajor) && !userCourses.contains(c)) {
				coursesMajor.add(c);
			}
		}
		System.out.println("Welcome to register a new course!");
		System.out.println("These are the courses available to you:");
		int j = 1;

		for (Course c : coursesMajor) {
			System.out.println(j + ". " + c.getCourseID());
			j++;
		}
		if (userCourses.size() == coursesMajor.size()) {
			System.out.println("\nNo courses to Register");
		}

		System.out.println("Or any other key to exit");
		int i = 0;
		try {
			i = Integer.parseInt(input.nextLine());

		} catch (Exception e) {
			return null;
		}
		if (coursesMajor.get(i - 1).getCapacity() == 0) {
			System.out.println("Class is Full");
			return null;
		} else {
			for (int k = 0; k < allCourses.size(); k++) {
				if (allCourses.get(k).getCourseID().equals(coursesMajor.get(i - 1).getCourseID())) {
					allCourses.get(k).setCapacity(allCourses.get(k).getCapacity() - 1);
					allCourses.get(k).setEnrolled(allCourses.get(k).getEnrolled() + 1);
					allCourses.get(k).getStudents().add(u);
					if (allCourses.get(k).getCapacity() == 0) {
						allCourses.get(k).setStatus("close");
					}
				}

			}

			System.out.println("The course is added to your schedule!");
		}

		return coursesMajor.get(i - 1);

	}

	public static String loginIdPass() {
		do {
			System.out.println("Please enter your login id: ");
			String userID = input.nextLine();
			System.out.println("Please enter your login password: ");
			String userPassword = input.nextLine();
			// int i;
			if (allUsers.stream().anyMatch(x -> x.getLogin().equals(userID) && x.getPassword().equals(userPassword))) {
				System.out.println("Login Successful!");
				return userID;
			} else {
				System.out.println("!!! Incorrect Login or password !!!");
			}

		} while (true);
	}

}
