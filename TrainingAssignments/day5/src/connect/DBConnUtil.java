
package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil{
	public static Connection getConnection(String ConnString) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver Loaded");
			con = DriverManager.getConnection(ConnString);
			//System.out.println("Database Connected");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Driver not Loaded");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Database failed to Connect");
		}
		return con;
	}
}