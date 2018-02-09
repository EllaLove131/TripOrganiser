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
public final class StudentQueries {

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
			System.out.println("There is a problem with the database.");
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
			System.out.println("There is a problem with the database.");
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
			System.out.println("There is a problem with the database.");
		}
	}

	/**
	 * Remove a student from the database
	 * 
	 * @param studentId
	 */
	public void removeStudent(int studentId) {

		String queryStudent = "DELETE FROM Student WHERE StudentId = ? ";
		String queryGroup = "DELETE FROM StudentGroup WHERE StudentId = ? ";
		String queryTrip = "DELETE FROM StudentTrip WHERE StudentId = ? ";

		try {
			queryRunner.execute(queryStudent, studentId);
			queryRunner.execute(queryGroup, studentId);
			queryRunner.execute(queryTrip, studentId);

		} catch (SQLException e) {
			System.out.println("There is a problem with the database.");
		}
	}
}