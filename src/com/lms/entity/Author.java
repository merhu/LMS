package com.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class Author {
	private int authorId;
	private String authorName;
	private List<Book> books;
	
	public Author() {
		authorId=0;
		authorName="";
		books = new ArrayList<Book>();
	}
	
	public Author(int authorId, String authorName, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.books = books;
	}
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
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
		Author other = (Author) obj;
		if (authorId != other.authorId)
			return false;
		return true;

	}
	
	
	
	@Override
	public String toString() {
		String  print=" ";
	
		
		print+="Author [authorId=" + authorId + ", authorName=" + authorName + ", books=\n";
		
		for(Book book:books) {
			print+=book.getBookTitle()+"\n";
		}
		
		return print.toString();
	}

	public static void main(String args[]) {
		Book book1=new Book();
		book1.setBookTitle("Test Book");
		
		Book book2=new Book();
		book2.setBookTitle("Test Book2");
		
		List<Book> books= new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		Author author1=new Author();
		author1.setAuthorName("Merry");
		author1.setBooks(books);
		
		
		System.out.println(author1.toString());

	}

	}
	
