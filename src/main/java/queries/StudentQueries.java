package queries;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import models.Student;
import resultSetHandlers.AutoGenKeyResultSetHandler;
import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 *         A container for database queries relating to students
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
	 * Add a student to a trip
	 * 
	 * @param studentId
	 * @param tripId
	 */
	public void addStudentToTrip(int studentId, int tripId) {

		String query = "INSERT INTO StudentTrip(studentId, tripId) VALUES (?, ?)";

		try {
			queryRunner.execute(query, studentId, tripId);
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
		String query3 = "DELETE FROM StudentTrip WHERE StudentId = ? ";

		try {
			queryRunner.execute(query, studentId);
			queryRunner.execute(query2, studentId);
			queryRunner.execute(query3, studentId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}