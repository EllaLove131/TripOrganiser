package resultSetHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Ella Love
 *
 * Used to convert student result sets into student objects 
 */
import org.apache.commons.dbutils.ResultSetHandler;

import models.Student;

public class StudentResultSetHandler implements ResultSetHandler<ArrayList<Student>> {

	public ArrayList<Student> handle(ResultSet rs) throws SQLException {

		ArrayList<Student> results = new ArrayList<Student>();

		while (rs.next()) {
			Student student = new Student();

			student.setStudentId(rs.getInt("studentId"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setMobileNo(rs.getString("mobileNo"));

			results.add(student);
		}
		return results;
	}
}
