package com.uhcl_system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClassNote {
	public static Scanner input = new Scanner(System.in);

	private String note;
	private String date;

	public void postCourseNote() {
		System.out.println("Please enter your new note:");
		String note = input.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		Date date = new Date();
		String noteDate = formatter.format(date);
		setNote(note);
		setDate(noteDate);
		System.out.println("Your note is added to the course. Your students can see it now!");
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}