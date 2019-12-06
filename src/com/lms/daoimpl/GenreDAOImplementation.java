package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.BaseDAO;
import com.lms.entity.Genre;
import com.lms.util.ConnectionUtil;

public class GenreDAOImplementation extends BaseDAO<Genre> {

	public GenreDAOImplementation(Connection conn) {
		super(conn);
	}
	//insert 
	public int insert(Genre genre) throws SQLException {
		String sql = "INSERT INTO `lmsv2`.`tbl_genre`(`genreId`,`genreName`) VALUES(?,?);"; 
		Object[] objs = {genre.getGenreId(), genre.getGenreName()};
		return save(sql, objs);
	}
	//update 
	public int update (Genre genre) throws SQLException {
		String sql = "UPDATE `lmsv2`.`tbl_genre` SET `genreName` = ? WHERE `genreId` = ?;";
		Object[] objs= {genre.getGenreId()};
		return save(sql, objs);
	}
	//delete
	public void delte(Genre genre) throws SQLException {
		String sql = "DELETE FROM `lmsv2`.`tbl_genre` WHERE <{?}";
		Object[] objs = {genre.getGenreId()};
		save(sql, objs);
	}
	//select
	public List<Genre> select() throws SQLException {
		String sql = "SELECT `tbl_genre`.`genreId`,`tbl_genre`.`genreName` FROM `lmsv2`.`tbl_genre`;";
		Object[] objs= null;
		return read(sql, objs);
	}
	@Override
	public List<Genre> extractData(ResultSet result) throws SQLException{
		List<Genre> genres = new ArrayList<>();
		
		while(result.next()) {
			Genre genre = new Genre();
			genre.setGenreId(result.getInt(1));
			genre.setGenreName(result.getString("genreName"));
			genres.add(genre);
    }
		return genres;
	}
	
	public static void main(String [] args) {
		try {
			
		Connection conn= ConnectionUtil.getConnection();
		GenreDAOImplementation GDAO = new GenreDAOImplementation(conn);
		Genre genre = new Genre();
		GDAO.insert(genre);
		conn.commit();
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
