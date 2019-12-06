package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.BaseDAO;
import com.lms.entity.Borrower;
import com.lms.util.ConnectionUtil;

public class BorrowerDAOImplementation extends  BaseDAO<Borrower> {
	
	public BorrowerDAOImplementation(Connection conn) {
		super(conn);
	}
	//insert
	public int insert(Borrower borrower) throws SQLException {
		String sql = "INSERT INTO `lmsv2`.`tbl_borrower`(`cardNo`,`name`,`address`,`phone`) VALUES(?,?,?,?);" ;
		Object[] objs = {borrower.getCardNo(), borrower.getBorrowerName(), borrower.getBorrowerAddress(), borrower.getBorrowerPhone()};
		return save(sql,objs);
	}
	//update
	public int update (Borrower borrower) throws SQLException {
		String sql  = "UPDATE `lmsv2`.`tbl_borrower`  SET `name`, `address`, `phone` = ? WHERE `cardNo` = ?;";
		Object[] objs = {borrower.getBorrowerName(), borrower.getBorrowerAddress(), borrower.getBorrowerPhone()};
		return save(sql, objs);
	}
	//delete - int 
	public void delte(Borrower borrower) throws SQLException {
		String sql = "DELETE FROM `lmsv2`.`tbl_borrower` WHERE `cardNo`=?;";
		Object[] objs = {borrower.getCardNo()};
		save(sql, objs);
	}
	//Select - 
	public List<Borrower> select() throws SQLException{
		String sql = "SELECT `tbl_borrower`.`cardNo`,`tbl_borrower`.`name`,`address`, `phone` FROM `lmsv2`.`tbl_borrower`;";
		Object[] objs=null;
		return read(sql, objs);
	}
	@Override
	public List<Borrower> extractData(ResultSet result) throws SQLException{
		List<Borrower> borrowers = new ArrayList<>();
		while(result.next()) {
			Borrower borrower = new Borrower();
			borrower.setCardNo(result.getInt(1));
			borrower.setBorrowerName(result.getString("name"));
			borrower.setBorrowerAddress(result.getString("address"));
			borrower.setBorrowerPhone(result.getInt(1));
			borrowers.add(borrower);
		}
		return borrowers;
	}
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			BorrowerDAOImplementation ADAO= new BorrowerDAOImplementation(conn);
	
			Borrower borrower = new Borrower(7, "Summer Walker", "136 Michigan ave, Northwest. Washington dc.", 232-565-7898, null);
			ADAO.insert(borrower);
			conn.commit();
//			Borrower borrower =new Borrower(7, "Summer Walker", "136 Michigan ave, Northwest. Washington dc.", 232-565-7898,null);
//			ADAO.update(borrower);
//			conn.commit();	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
