/**
 * 
 */
package triporganiser.triporganiser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

/**
 * @author Ella Love
 *
 */
public class StudentQueries {
	
	private QueryRunner queryRunner;

	public StudentQueries()
	{
		queryRunner = new QueryRunner(DatabaseConnectionPoolHandler.getInstance().getDataSource());
	}
	
	/**
	 * Add a new student to the database
	 */
	public void addStudent(Student student) {

		String query = "INSERT INTO Student(firstName, lastName, mobileNo) " + "VALUES (?, ?, ?)";
	
		try {
			queryRunner.execute(query, new StudentResultSetHandler(), 
					student.getFirstName(), student.getLastName(), student.getMobileNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove a student from the database
	 */
	public void removeStudent(Student student) {
		String query = "DELETE FROM Student WHERE StudentId = ?";
		
		try {
			queryRunner.execute(query, new StudentResultSetHandler(), student.getStudentId());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Student> getStudents() {
		
		ArrayList<Student> results = new ArrayList<Student>();
		
		try {
			results = queryRunner.query(
				    "SELECT * FROM Student", new StudentResultSetHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
