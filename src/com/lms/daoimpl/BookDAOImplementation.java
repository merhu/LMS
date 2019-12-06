package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.BaseDAO;
import com.lms.entity.Author;
import com.lms.entity.Book;
import com.lms.util.ConnectionUtil;

public  class BookDAOImplementation extends BaseDAO<Book> {
	
	public BookDAOImplementation (Connection con) {
		super(con);
	}
	//insert 
	public int insert(Book book) throws SQLException {
		String sql =  "INSERT INTO `lmsv2`.`tbl_book`(`bookId`,`title`,`publisherId`) VALUES(?,?,?,?,?);" ;
		Object[] objs = {book.getBookId(),book.getBookTitle(),book.getPublisherId()};
		return save(sql,objs);
	}
	//update 
	public int update(Book book) throws SQLException {
		String sql ="UPDATE `lmsv2`.`tbl_book` SET `title` = ?,`publisherId` = ? WHERE `bookId` = ?;";
		Object[] objs = {book.getBookTitle(), book.getBookId(), book.getPublisherId()};
		return save(sql,objs);
	}
	//delete
	public void delete(Book book) throws SQLException {
		String sql = "DELETE FROM 'lmsv2'.'tbl_book' WHERE =? ";
		Object[] objs = {book.getBookId()};
		save(sql,objs);
	}
	public List<Book> select() throws SQLException{
		String sql = "SELECT `tbl_book`.`bookId`,`tbl_book`.`title`,`publisherId` FROM `lmsv2`.`tbl_book`;";
		Object[] objs=null;
		return read(sql,objs);
	}
	@Override
	public List<Book> extractData(ResultSet result) throws SQLException {
		List<Book> books = new ArrayList<>();
		
		while(result.next()) {
			Book book = new Book();
			book.setBookId(result.getInt(1));
			book.setBookTitle(result.getString("title"));
			book.setPublisherId(result.getInt(1));
			books.add(book);
		}
	return books;
	}
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			BookDAOImplementation ADAO = new BookDAOImplementation(conn);

//			BookDAOImplementation ADAO = new BookDAOImplementation(conn);
//			Book book = new Book(17, "New Moon", 11, null, null);
//			ADAO.insert(book);
//			conn.commit();
			
			Book book = new Book(18, "Java and merry", 8, null, null);
			ADAO.update(book);
			conn.commit();
			
//			Book book = new Book(1)
//			List<Book> books=null;
//			books=ADAO.select();
//			conn.commit();
//			
//			for(Book book : books) {
//				System.out.println("Book id: "+ book.getBookId() +" Book title: "
//			+ book.getBookTitle() + "Publisher iD: " + " "+ book.getPublisherId());
//			}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}

