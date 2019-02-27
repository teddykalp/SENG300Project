import java.sql.*;

public class createStudentDB {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	// Database credentials
	static final String USER = "SENGSQUAD";
	static final String PASS = "GETTHISBREAD";
	
	public static void main(String [] args){
		Connection conn = null;
		Statement stmt = null;
		
		try{
			// Register JDBC Driver
			Class.forName(JDBC_DRIVER);
			//Open a connection
			System.out.println("Connecting to Database");
			conn = DriverManager.getConnection(DB_URL);
			
			// Execute query
			System.out.println("Creating Database");
			stmt = conn.createStatement();
			
			String sql = "Create Database Students";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully");
			
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
