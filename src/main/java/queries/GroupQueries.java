package queries;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import models.Group;
import models.Student;
import resultSetHandlers.GroupResultSetHandler;
import resultSetHandlers.StudentResultSetHandler;
import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 *         A container for database queries relating to groups
 */
public final class GroupQueries {

	private QueryRunner queryRunner;

	public GroupQueries() {
		queryRunner = new QueryRunner(DatabaseConnectionPoolHandler.getInstance().getDataSource());
	}

	/**
	 * Add a new group to the database
	 * 
	 * @param group
	 */
	public void addGroup(Group group) {

		String query = "INSERT INTO TripOrganiser.Group(groupName) VALUES (?);";

		try {
			queryRunner.execute(query, group.getGroupName());
		} catch (SQLException e) {
			System.out.println("There is a problem with the database.");
		}
	}

	/**
	 * Remove a group from the database
	 * 
	 * @param groupId
	 */
	public void removeGroup(int groupId) {
		
		String queryGroup = "DELETE FROM TripOrganiser.Group WHERE GroupId = ?";

		// Delete the group
		try {
			queryRunner.execute(queryGroup, groupId);
		} catch (SQLException e) {
			System.out.println("There is a problem with the database.");
		}
		
		//Delete the associated students
		for (Student student : getStudentsFromGroup(groupId)) {
			//Get the student ID's
			int studentId = student.getStudentId();
			
			//Remove the students
			new StudentQueries().removeStudent(studentId);
		}
	}

	/**
	 * Gets all of the groups from the db
	 * 
	 * @return arrayList of all groups
	 */
	public ArrayList<Group> getGroups() {

		ArrayList<Group> results = new ArrayList<Group>();

		try {
			results = queryRunner.query("SELECT * FROM TripOrganiser.Group", new GroupResultSetHandler());

		} catch (SQLException e) {
			System.out.println("There is a problem with the database.");
		}

		return results;
	}

	/**
	 * get the students in a given group
	 * 
	 * @param groupId
	 * @return results
	 */
	public ArrayList<Student> getStudentsFromGroup(int groupId) {

		ArrayList<Student> results = new ArrayList<Student>();

		String query = "SELECT Student.studentId, firstName, lastName, mobileNo " + "FROM Student "
				+ "LEFT JOIN StudentGroup ON Student.studentId = StudentGroup.studentId " + "WHERE groupId = ?";

		try {
			results = queryRunner.query(query, new StudentResultSetHandler(), groupId);

		} catch (SQLException e) {
			System.out.println("There is a problem with the database.");
		}
		return results;
	}
}
