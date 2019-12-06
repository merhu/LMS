package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lms.util.ConnectionUtil;

public abstract class BaseDAO<T> {
	Connection con=null;
  public  BaseDAO(Connection con){
		this.con=con;
  }
	//save ~ update, delete, insert 
	public  int save(String sql,Object[] objs) throws SQLException {
		PreparedStatement pstms =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		int index=1;
		if(objs!=null) {
			for(Object obj:objs) {
				pstms.setObject(index, obj);
				index++;
			}
		}
		pstms.executeUpdate();
		return pstms.executeUpdate();
	}
	//read 	
	public List<T> read(String sql,Object[] objs) throws SQLException{
		PreparedStatement pstms =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		int index=1;
		if(objs!=null) {
			for(Object obj:objs) {
				pstms.setObject(index, obj);
				index++;
			}
		}
		ResultSet result=pstms.executeQuery();
		return extractData(result);
	}
	public abstract List<T>  extractData(ResultSet result) throws SQLException;
}
