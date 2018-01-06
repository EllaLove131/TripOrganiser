package ResultSetHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.dbutils.ResultSetHandler;

import Models.Student;
import Models.StudentTrip;

/**
 * 
 * @author Ella Love
 *
 * Used to convert student trip result sets into student trip objects 
 */
public class StudentTripResultSetHandler implements ResultSetHandler<ArrayList<StudentTrip>> {

	public ArrayList<StudentTrip> handle(ResultSet rs) throws SQLException {
		
        Iterator<Student> students = new StudentResultSetHandler().handle(rs).iterator();
        ArrayList<StudentTrip> results = new ArrayList<StudentTrip>();

        
        if (rs != null)
        {
        	rs.beforeFirst();
        	
        	while(rs.next())
        	{
        		StudentTrip studentTrip = new StudentTrip(students.next());
        		
        		studentTrip.setPaid(rs.getBoolean("paid"));
        		studentTrip.setAuthorisation(rs.getBoolean("authorisation"));
        		studentTrip.setStudentTripId(rs.getInt("studentTripId"));
        		
        		results.add(studentTrip);
        	}
        }
		return results;
	}   
}
