/**
 * A container for database queries relating to trips
 */
package Queries;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;

import Models.StudentTrip;
import Models.Trip;
import ResultSetHandlers.StudentTripResultSetHandler;
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
	 * 
	 * @param trip
	 */
	public void addTrip(Trip trip) {

		String query = "INSERT INTO Trip(tripName, tripType, startDate, endDate, entranceFee, sundryFee, transportType, "
				+ "transportDeparture, transportArrival, venue, accommodation, accommodationArrival, "
				+ "accommodationDeparture, approvalRequired) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			queryRunner.execute(query, trip.getTripName(), trip.getTripType(), trip.getStartDate(), trip.getEndDate(),
					trip.getEntranceFee(), trip.getSundryFee(), trip.getTransportType(), trip.getTransportDeparture(),
					trip.getTransportArrival(), trip.getVenue(), trip.getAccommodation(),
					trip.getAccommodationArrival(), trip.getAccommodationDeparture(), trip.isApprovalRequired());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all of the trips from the database
	 * 
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

	/**
	 * Get the students that belong to a specific group
	 * 
	 * @param tripId
	 * @return students
	 */
	public ArrayList<StudentTrip> getStudentsFromTrip(int tripId) {

		ArrayList<StudentTrip> results = new ArrayList<StudentTrip>();

		String query = "SELECT Student.studentId, firstName, lastName, mobileNo, StudentTrip.studentTripId, StudentTrip.paid, StudentTrip.authorisation " + "FROM Student "
				+ "LEFT JOIN StudentTrip ON Student.studentId = StudentTrip.studentId " + "WHERE tripId = ?";

		try {
			results = queryRunner.query(query, new StudentTripResultSetHandler(), tripId);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * Removes a student from a trip
	 * @param studentId
	 */
	public void removeStudentFromTrip(int studentId) { 

		String query = "DELETE FROM StudentTrip WHERE StudentId = ? ";

		try {
			queryRunner.execute(query, studentId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a trip
	 */
	public void removeTrip(int tripId) { 
		
		String query = "DELETE FROM Trip WHERE tripId = ? ";

		try {
			queryRunner.execute(query, tripId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setPaid(int studentTripId, Boolean value) {
		
		String query = "UPDATE StudentTrip SET paid = ? WHERE studentTripId = ? ";

		try {
			queryRunner.execute(query, value, studentTripId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setAuthorisation(int studentTripId, Boolean value) { 
		
		String query = "UPDATE StudentTrip SET authorisation = ? WHERE studentTripId = ? ";

		try {
			queryRunner.execute(query, value, studentTripId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
