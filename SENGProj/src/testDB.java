import java.sql.*;



public class testDB {
	
	
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 String url = "jdbc:odbc:studentDSN";
		 Connection con = DriverManager.getConnection(url);
		 Statement st = con.createStatement();
		 String sql = "SELECT * FROM studentDB";
		 ResultSet rs = st.executeQuery(sql);
		 while(rs.next()){
			 String name = rs.getString("studentName");
			 String lname = rs.getString("studentLast");
			 System.out.println(name + " " + lname);
		 }
		 con.close();
		
	
	}}
