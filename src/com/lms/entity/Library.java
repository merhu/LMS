package com.lms.entity;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Library {

	private int libraryId; 
	private String libraryName;
	private String libraryAddress;
	private int libraryPhone;
	private List<Loan> loans;
	Hashtable <Book, Integer> bookCopies;
	
	public Library(int libraryId, String libraryName, String libraryAddress, int libraryPhone, List<Loan> loans,
			Hashtable<Book, Integer> bookCopies) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
		this.libraryPhone = libraryPhone;
		this.loans = loans;
		this.bookCopies = bookCopies;
	
	}
	public Library() {
		libraryId=0;
		libraryName="";
		libraryAddress = "";
		libraryPhone=0;
		loans = new ArrayList<Loan>();
		bookCopies = new Hashtable <Book, Integer>();
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getLibraryAddress() {
		return libraryAddress;
	}
	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}
	public int getLibraryPhone() {
		return libraryPhone;
	}
	public void setLibraryPhone(int libraryPhone) {
		this.libraryPhone = libraryPhone;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public Hashtable<Book, Integer> getBookCopies() {
		return bookCopies;
	}
	public void setBookCopies(Hashtable<Book, Integer> bookCopies) {
		this.bookCopies = bookCopies;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + libraryId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		if (libraryId != other.libraryId)
			return false;
		return true;
	}
//	@Override
//	public String toString() {
//		String print="";
//	
//		print+= "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", libraryAddress=" + libraryAddress
//				+ ", libraryPhone=" + libraryPhone + "\n" + " loans=" + loans + 
//						 "bookCopies=" + bookCopies ;
//		
//		for(Loan loan:loans) {
//			print+=loan.getBooks() + "\n";
//			
//		}
//		return print.toString();
//	}
//	public static void main(String args[]){
//		Loan loan1 = new Loan();
//		loan1.setBooks(1);
//		List<Loan> loan1 = new ArrayList<Loan>();
//		loan1.add("")
//	}
}
