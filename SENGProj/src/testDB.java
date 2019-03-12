import java.sql.*;



public class testDB {
	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public static void main(String [] args){
		
		 try {
			 String url = "jdbc:odbc:staffDB";
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 
			  con = DriverManager.getConnection(url);
			  st = con.createStatement();
			  
			  rs = st.executeQuery("SELECT * FROM staff");
			  
			  while(rs.next()) {
				  System.out.println(rs.getString(1));
			  }
		 }catch(Exception e) {
			 System.out.print("does not work");
		 }
	
}
}
