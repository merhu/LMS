package com.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {
		private int bookId;
		private String bookTitle;
		private int publisherId;
		private List <Genre> genres;
		private List <Author> authors;
		public Book(int bookId, String bookTitle, int publisherId, List<Genre> genres, List<Author> authors) {
			super();
			this.bookId = bookId;
			this.bookTitle = bookTitle;
			this.publisherId = publisherId;
			this.genres = genres;
			this.authors = authors;
		}
		//Default constructor to set the value 
		public Book(){
			bookId = 0; 
			bookTitle = "";
			publisherId = 0;
			genres = new ArrayList<Genre>();
			authors = new ArrayList<Author>();
		}
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public int getPublisherId() {
			return publisherId;
		}
		public void setPublisherId(int publisherId) {
			this.publisherId = publisherId;
		}
		public List<Genre> getGenres() {
			return genres;
		}

		public void setGenres(List<Genre> genres) {
			this.genres = genres;
		}

		public List<Author> getAuthors() {
			return authors;
		}

		public void setAuthors(List<Author> authors) {
			this.authors = authors;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bookId;
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
			Book other = (Book) obj;
			if (bookId != other.bookId)
				return false;
			return true;
		}
		@Override
		public String toString() {
			String print = "";
			print+= "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", genres=" + genres + ", authors= \n";
			
			for(Author author:authors) {
				print+= author.getAuthorName()+"\n";
				
			}
			return print.toString();
		}
		public static void main(String args[]) {
			Author author1 = new Author();
			author1.setAuthorName("Merhawit Gezahegn");
			
			Author author2 = new Author();
			author2.setAuthorName("Tewodros Kassahun");
			
			List<Author> authors = new ArrayList<Author>();
			authors.add(author1);
			authors.add(author2);
			
			Book book1 = new Book();
			book1.setBookTitle("To Kill A Mokingbird");
			book1.setAuthors(authors);
			System.out.println(book1.toString());
		

		
		}
	}


