/**
 * A container for database queries relating to groups
 */
package Queries;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import Models.Group;
import Models.Student;
import ResultSetHandlers.GroupResultSetHandler;
import ResultSetHandlers.StudentResultSetHandler;
import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 */
public class GroupQueries {

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
			e.printStackTrace();
		}
	}

	/**
	 * Remove a group from the database
	 * 
	 * @param groupId
	 */
	public void removeGroup(int groupId) {
		
		String query = "DELETE FROM TripOrganiser.Group WHERE GroupId = ?";

		try {
			queryRunner.execute(query, groupId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Group> getGroups() {

		ArrayList<Group> results = new ArrayList<Group>();

		try {
			results = queryRunner.query("SELECT * FROM TripOrganiser.Group", new GroupResultSetHandler());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	 /**
	  * get the students in a given group
	  * @param groupId
	  * @return results
	  */
	public ArrayList<Student> getStudentsFromGroup(int groupId) { 
		
		ArrayList<Student> results = new ArrayList<Student>();
		
		String query = "SELECT Student.studentId, firstName, lastName, mobileNo "
				+ "FROM Student "
				+ "LEFT JOIN StudentGroup ON Student.studentId = StudentGroup.studentId "
				+ "WHERE groupId = ?";
		
		try {
			results = queryRunner.query(query, new StudentResultSetHandler(), groupId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
