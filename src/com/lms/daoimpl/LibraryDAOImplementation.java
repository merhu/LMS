package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.BaseDAO;
import com.lms.entity.Author;
import com.lms.entity.Library;
import com.lms.util.ConnectionUtil;

public class LibraryDAOImplementation extends BaseDAO<Library> {

	public LibraryDAOImplementation (Connection conn) {
		super(conn);
	}
	//insert
	public int insert(Library library) throws SQLException {
		String sql = "INSERT INTO `lmsv2`.`tbl_library_branch`(`branchId`,`branchName`,`branchAddress`,`branchPhone`) VALUES(?,?,?);" ;
		Object[] objs = {library.getLibraryId(), library.getLibraryName(), library.getLibraryAddress(), library.getLibraryPhone()};
		return save(sql, objs);
	}
	//update
	public int update(Library library) throws SQLException {
		String sql= "UPDATE `lmsv2`.`tbl_library_branch` SET `branchName`,`branchAddress`,`branchPhone` = ? WHERE `branchId` = ?;";
		Object[] objs = {library.getLibraryId()}; 
		return save(sql, objs);
	}
	//delete
	public void delete(Library library) throws SQLException {
		String sql = "DELETE FROM `lmsv2`.`tbl_library_branch` WHERE <{?}";
		Object[] objs = {library.getLibraryId()};
		save(sql, objs);
	}
	//select
	public List<Library> select() throws SQLException{
		String sql= "SELECT `tbl_library_branch`.`branchId`,`tbl_library_branch`.`branchName`,`branchAddress` FROM `lmsv2`.`tbl_library_branch`;";
		Object[] objs= null;
		return read(sql, objs);
	}
	@Override
	public List<Library> extractData(ResultSet result) throws SQLException {
		List<Library> libraries=new ArrayList<>();
	
	while(result.next()) {
		Library library=new Library();
		library.setLibraryId(result.getInt(1));
		library.setLibraryName(result.getString("branchName"));
		library.setLibraryName(result.getString("branchAddress"));
		libraries.add(library);
    }
	return libraries;
}
	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();
		LibraryDAOImplementation LDAO = new LibraryDAOImplementation(conn);

//		Library library = new Library(7, "Merhaett hgehe", "123 Rowned st, Silver spring.MD");
		LDAO.insert(library);
		conn.commit();
}
}