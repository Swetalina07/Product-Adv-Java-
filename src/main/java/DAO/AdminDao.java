package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Beans.UserBean;
import DBInfo.DBConnection;


public class AdminDao {
	public int insert(UserBean ub)
	{
		int k=0;
		try {
	
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into admin55 values(?,?,?,?,?,?)");
			ps.setString(1,ub.getUserName());
			ps.setString(2,ub.getPassWord());
			ps.setString(3,ub.getFirstName());
			ps.setString(4,ub.getLastName());
			ps.setString(5,ub.getEmail());
			ps.setLong(6,ub.getMobile());
			
			k=ps.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}