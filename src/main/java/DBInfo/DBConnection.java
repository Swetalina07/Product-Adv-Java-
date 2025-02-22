package DBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static DBInfo.InfoDB.*;
public class DBConnection 
{
	private static Connection con;
	private DBConnection() {
		
	}
	static {
		try
		{
		Class.forName(drive);
		con=DriverManager.getConnection(url,uName,pWord);
		}
		catch (Exception e) 
		{

		}
	}
	public static Connection getConnection() throws SQLException
	{
		
		if(con==null)
		{
			con=DriverManager.getConnection(url,uName,pWord);
			return con;
		}
			else
		return con;
	}


}
