package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.BaseDAO;
import com.lms.entity.Author;
import com.lms.util.ConnectionUtil;

public class AuthorDAOImplementation extends BaseDAO<Author> {

	public AuthorDAOImplementation(Connection con){
		super(con);
	}
  // insert - int
	public int insert(Author author) throws SQLException {	
		String sql = "INSERT INTO `lmsv2`.`tbl_author`(`authorId`,`authorName`) VALUES(?,?);" ;
		Object[] objs= {author.getAuthorId(),author.getAuthorName()};
		return save(sql,objs);	
	}
  // update  - int 
	public int update(Author author) throws SQLException {
		String sql = "UPDATE `lmsv2`.`tbl_author` SET `authorName` = ? WHERE `authorId` = ?;";
		Object[] objs = {author.getAuthorId()}; 
		return save(sql, objs);
	}
  // delete - int 
	public void delete(Author author) throws SQLException {
		String sql = "DELETE FROM `lmsv2`.`tbl_author` WHERE <{?}";
		Object[] objs = {author.getAuthorId()}; 
		 save(sql, objs);
	}
	
 // select 
	public List<Author> select() throws SQLException{
		String sql = "SELECT `tbl_author`.`authorId`,`tbl_author`.`authorName` FROM `lmsv2`.`tbl_author`;";
		Object[] objs=null;
		return read(sql,objs);
	}
	@Override
	public List<Author> extractData(ResultSet result) throws SQLException {
		List<Author> authors=new ArrayList<>();
		
		while(result.next()) {
			Author author=new Author();
	    	author.setAuthorId(result.getInt(1));
	    	author.setAuthorName(result.getString("authorName"));
	    	authors.add(author);
	    }
		return authors;
	}
	
	public static void main(String[] args ){
		try {
			Connection con=ConnectionUtil.getConnection();
			AuthorDAOImplementation ADAO=new AuthorDAOImplementation(con);
			/*
			 * Author author=new Author(7,"Tewodros Kasahun",null); AuthorDAOImplementation
			 * ADAO=new AuthorDAOImplementation(con); ADAO.insert(author); con.commit();
			 */
			
			Author author =new Author(7,"Tewodros B Kasahun",null);
			ADAO.update(author);
			con.commit();	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
