package com.lms.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Loan {

	private List<Book> books;
	private List<Borrower> borrowers;
	private Date dayIn;
	private Date dayOut;
	private Date dueDate;
	
	public Loan(List<Book> books, List<Borrower> borrowers, Date dayIn, Date dayOut, Date dueDate) {
		super();
		this.books = books;
		this.borrowers = borrowers;
		this.dayIn = dayIn;
		this.dayOut = dayOut;
		this.dueDate = dueDate;
	}
	public Loan() {
		books = new ArrayList<Book>();
		borrowers = new ArrayList<Borrower>();
		dayIn= null;
		dayOut= null;
		dueDate=null;
	}
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Borrower> getBorrowers() {
		return borrowers;
	}
	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
	public Date getDayIn() {
		return dayIn;
	}
	public void setDayIn(Date dayIn) {
		this.dayIn = dayIn;
	}
	public Date getDayOut() {
		return dayOut;
	}
	public void setDayOut(Date dayOut) {
		this.dayOut = dayOut;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
