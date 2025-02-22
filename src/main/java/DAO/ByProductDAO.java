package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.ProductBean;
import DBInfo.DBConnection;

public class ByProductDAO {
	
	private int k=0;
	
	public int purchase(ProductBean ab) {
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update product55 set qty=? where code=?");
			
			ps.setInt(1, ab.getQty());
			ps.setString(2, ab.getCode());
			
			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
