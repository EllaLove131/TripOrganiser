/**
 * 
 */
package Queries;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import Models.Student;
import ResultSetHandlers.AutoGenKeyResultSetHandler;
import ResultSetHandlers.StudentResultSetHandler;
import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 */
public class StudentQueries {

	private QueryRunner queryRunner;

	public StudentQueries() {
		queryRunner = new QueryRunner(DatabaseConnectionPoolHandler.getInstance().getDataSource());
	}

	/**
	 * Add a new student to the database
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {

		String query = "INSERT INTO Student(firstName, lastName, mobileNo) VALUES (?, ?, ?)";

		try {
			Integer studentId = queryRunner.insert(query, new AutoGenKeyResultSetHandler(), student.getFirstName(),
					student.getLastName(), student.getMobileNo());

			student.setStudentId(studentId.intValue());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add a students to a group
	 * 
	 * @param student
	 * @param groupId
	 */
	public void addStudentToGroup(Student student, int groupId) {

		String query = "INSERT INTO StudentGroup(studentId, groupId) VALUES (?, ?)";

		try {
			queryRunner.execute(query, student.getStudentId(), groupId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove a student from the database
	 * 
	 * @param studentId
	 */
	public void removeStudent(int studentId) {

		String query = "DELETE FROM Student WHERE StudentId = ? ";
		String query2 = "DELETE FROM StudentGroup WHERE StudentId = ? ";

		try {
			queryRunner.execute(query, new AutoGenKeyResultSetHandler(), studentId);
			queryRunner.execute(query2, new AutoGenKeyResultSetHandler(), studentId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove a student from a group
	 */
	public void removeStudentFromGroup(int studentId, int groupId) {
		// TODO complete
	}

	/**
	 * Get all students
	 * 
	 * @return and arraylist of students
	 */
	public ArrayList<Student> getAllStudents() {

		ArrayList<Student> results = new ArrayList<Student>();

		try {
			results = queryRunner.query("SELECT * FROM Student", new StudentResultSetHandler());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}