//package triporganiser.triporganiser;
//
//import java.sql.*;
//
//public class HelloWorldDB {
//
//	public void connectToAndQueryDatabase(String username, String password) throws SQLException {
//
//	    Connection con = DriverManager.getConnection(
//	                         "jdbc:mysql://programming2.clql2aelajju.us-east-2.rds.amazonaws.com/TripOrganiser",
//	                         username,
//	                         password);
//
//	    Statement stmt = con.createStatement();
//	    ResultSet rs = stmt.executeQuery("SELECT firstname, lastname FROM students");
//
//	    while (rs.next()) {
//	       System.out.println(rs.getString("firstname"));
//	       System.out.println(rs.getString("lastname"));
//	    }
//	    
//	    con.close();
//	}
//}
