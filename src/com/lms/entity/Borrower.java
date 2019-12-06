package com.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
	private int cardNo;
	private String borrowerName; 
	private String borrowerAddress;
	private int borrowerPhone;
	private List<Loan> loans;
	public Borrower(int cardNo, String borrowerName, String borrowerAddress, int borrowerPhone, List<Loan> loans) {
		super();
		this.cardNo = cardNo;
		this.borrowerName = borrowerName;
		this.borrowerAddress = borrowerAddress;
		this.borrowerPhone = borrowerPhone;
		this.loans = loans;
	}
	public Borrower() {
		cardNo = 0;
		borrowerName="";
		borrowerAddress = "";
		borrowerPhone=0;
		loans = new ArrayList<Loan>();
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getBorrowerAddress() {
		return borrowerAddress;
	}
	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
	}
	public int getBorrowerPhone() {
		return borrowerPhone;
	}
	public void setBorrowerPhone(int borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardNo;
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
		Borrower other = (Borrower) obj;
		if (cardNo != other.cardNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		String print="";
		
		print+= "Borrower +  [cardNo=" + cardNo + ", borrowerName=" + borrowerName + ", borrowerAddress=" + borrowerAddress
				+ ", borrowerPhone=" + borrowerPhone + ", loans=\n";
		for (Loan loan:loans) {
			print+=loan.getBorrowers() +"\n";
		}
		return print.toString();
	}
	public static void main(String args[]) {
		
		Borrower borrower1 = new Borrower();
		borrower1.setBorrowerPhone(2027170987);
		borrower1.setBorrowerName("Merhawit Gezahegn");
		borrower1.setCardNo(3457964);
		
		List<Borrower> borrowers = new ArrayList<Borrower>();
		borrowers.add(borrower1);
		
		
		System.out.println(borrowers.toString());
		
	}
}