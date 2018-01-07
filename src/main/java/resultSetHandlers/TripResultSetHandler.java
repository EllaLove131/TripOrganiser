package resultSetHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

import models.Trip;

/**
 * 
 * @author Ella Love
 *
 *         Used to convert trip result sets into trip objects
 */
public class TripResultSetHandler implements ResultSetHandler<ArrayList<Trip>> {

	public ArrayList<Trip> handle(ResultSet rs) throws SQLException {

		ArrayList<Trip> results = new ArrayList<Trip>();

		while (rs.next()) {
			Trip trip = new Trip();

			trip.setTripType(rs.getString("tripType"));
			trip.setTripId(rs.getInt("tripId"));
			trip.setTripName(rs.getString("tripName"));
			trip.setStartDate(rs.getString("startDate"));
			trip.setEndDate(rs.getString("endDate"));
			trip.setEntranceFee(rs.getDouble("entranceFee"));
			trip.setTransportType(rs.getString("transportType"));
			trip.setTransportDeparture(rs.getString("transportDeparture"));
			trip.setTransportArrival(rs.getString("transportArrival"));
			trip.setApprovalRequired(rs.getBoolean("approvalRequired"));

			String tripType = trip.getTripType();

			if (tripType.equals("ResidentialTeacher")) {
				trip.setSundryFee(rs.getDouble("sundryFee"));
				trip.setVenue(rs.getString("venue"));
				trip.setAccommodation(rs.getString("accommodation"));
				trip.setAccommodationArrival(rs.getString("accommodationArrival"));
				trip.setAccommodationDeparture(rs.getString("accommodationDeparture"));
			}
			if (tripType.equals("DayTeacher")) {
				trip.setSundryFee(rs.getDouble("sundryFee"));
				trip.setVenue(rs.getString("venue"));
			}
			results.add(trip);
		}
		return results;
	}
}
