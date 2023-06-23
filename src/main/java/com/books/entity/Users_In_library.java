package com.books.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users_In_library {
	
	@Id
	private int id;
	private String name;
	private String book_name;
	private String Book_Entry_Date;
	private String Book_Submit_Date;
	private int Due_of_Late_Submit;

	private String name_of_Librarian;

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

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_Entry_Date() {
		return Book_Entry_Date;
	}

	public void setBook_Entry_Date(String book_Entry_Date) {
		Book_Entry_Date = book_Entry_Date;
	}

	public String getBook_Submit_Date() {
		return Book_Submit_Date;
	}

	public void setBook_Submit_Date(String book_Submit_Date) {
		Book_Submit_Date = book_Submit_Date;
	}

	public int getDue_of_Late_Submit() {
		return Due_of_Late_Submit;
	}

	public void setDue_of_Late_Submit(int due_of_Late_Submit) {
		Due_of_Late_Submit = due_of_Late_Submit;
	}

	public String getName_of_Librarian() {
		return name_of_Librarian;
	}

	public void setName_of_Librarian(String name_of_Librarian) {
		this.name_of_Librarian = name_of_Librarian;
	}

	@Override
	public String toString() {
		return "User_In_library [id=" + id + ", name=" + name + ", book_name=" + book_name + ", Book_Entry_Date="
				+ Book_Entry_Date + ", Book_Submit_Date=" + Book_Submit_Date + ", Due_of_Late_Submit="
				+ Due_of_Late_Submit + ", name_of_Librarian=" + name_of_Librarian + "]";
	}

}
