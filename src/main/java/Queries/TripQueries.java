/**
 * 
 */
package Queries;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import Models.Trip;
import ResultSetHandlers.TripResultSetHandler;
import triporganiser.triporganiser.DatabaseConnectionPoolHandler;

/**
 * @author Ella Love
 *
 */
public class TripQueries {

	private QueryRunner queryRunner;

	public TripQueries() {
		queryRunner = new QueryRunner(DatabaseConnectionPoolHandler.getInstance().getDataSource());
	}

	public void addTrip(Trip trip) {
		
		String query = "INSERT INTO Trip(TripName) VALUES (?);";
		
		try {
			queryRunner.execute(query, new TripResultSetHandler(), trip.getTripName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
