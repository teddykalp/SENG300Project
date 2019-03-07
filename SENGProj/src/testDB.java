import java.sql.*;



public class testDB {
	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public static void main(String [] args){
		
		 try {
			 	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	            Class.forName(driver);
	            
	            String db = "jdbc:odbc:test";
	            
	            con = DriverManager.getConnection(db);
	            st = con.createStatement();
	            String sql = "select * from courseDB";
	            rs = st.executeQuery(sql);
	            
	            while(rs.next())
	            {
	            	String cname = rs.getString("courseName");
	            	String cID = rs.getString("courseID");
	            	
	            	System.out.println(cname + " " + cID);
	            }

	           

	        } catch (Exception e) {

	            System.out.println(e.getMessage());

	        }
		
		
		
		
	}
	
}
