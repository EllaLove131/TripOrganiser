/**
 * 
 */
package Queries;

import java.sql.SQLException;
import java.util.ArrayList;

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

	/**
	 * Adds a trip to the database 
	 * @param trip
	 */
	public void addTrip(Trip trip) {

		String query = "INSERT INTO Trip(tripName, tripType, startDate, endDate, entranceFee, sundryFee, transportType, transportDeparture, transportArrival, venue, accommodation, accommodationArrival, accommodationDeparture, approvalRequired) " 
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			queryRunner.execute(query, new TripResultSetHandler(), trip.getTripName(), trip.getTripType(),
					trip.getStartDate(), trip.getEndDate(), trip.getEntranceFee(), trip.getSundryFee(),
					trip.getTransportType(), trip.getTransportDeparture(), trip.getTransportArrival(), trip.getVenue(),
					trip.getAccommodation(), trip.getAccommodationArrival(), trip.getAccommodationDeparture(),
					trip.isApprovalRequired());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get all of the trips from the database 
	 * @return ArrayList of trips 
	 */
	public ArrayList<Trip> getTrips() { 
		
		ArrayList<Trip> results = new ArrayList<Trip>();

		try {
			results = queryRunner.query("SELECT * FROM Trip", new TripResultSetHandler());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
