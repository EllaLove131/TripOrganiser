package queries;

import java.sql.SQLException;

import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 *         Class to check the database connection.
 */
public final class HealthQueries {


	/**
	 * Checks that there is a database connection.
	 * 
	 * @return false if there is no database connection.
	 */
	public static Boolean isHealthy() {
		try {
			// Get a connection to the database. 
			DatabaseConnectionPoolHandler.getInstance().getDataSource().getConnection();

		} catch (SQLException e) {
			return false;
		}

		return true;
	}
}
