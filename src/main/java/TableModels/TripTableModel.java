/**
 * 
 */
package TableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Models.Trip;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class TripTableModel extends AbstractTableModel {

	public static final int TRIP_NAME_COLUMN = 0;
	public static final int TRIP_ID_COLUMN = 1;
	public static final int START_COLUMN = 2;
	public static final int END_COLUMN = 3;
	public static final int TRAVEL_TYPE_COLUMN = 4;
	public static final int TRAVEL_DEPARTURE_COLUMN = 5;
	public static final int TRAVEL_ARRIVAL_COLUMN = 6;
	public static final int ACCOMMODATION_COLUMN = 7;
	public static final int ACCOMMODATION_ARRIVAL_COLUMN = 8;
	public static final int ACCOMMODATION_DEPARTURE_COLUMN = 9;
	public static final int ENTRANCE_FEE_COLUMN = 10;
	public static final int SUNDRY_FEE_COLUMN = 11;
	public static final int VENUE_COLUMN = 12;
	public static final int APPROVAL_REQUIRED_COLUMN = 13;
	public static final int TRIP_TYPE_COLUMN = 14;

	private ArrayList<Trip> trips;
	private String[] columns;

	public TripTableModel(ArrayList<Trip> tripList) {

		super();
		trips = tripList;
		columns = new String[] { "Trips:" };
	}

	// Number of columns in the table
	public int getColumnCount() {
		return columns.length;
	}

	// Number of row in the table
	public int getRowCount() {
		return trips.size();
	}

	// The object to place into a cell
	public Object getValueAt(int row, int col) {
		if (trips.isEmpty()) {
			return null;
		}

		// check the row is valid
		if (row > trips.size() || row < 0) {
			return null;
		}

		Trip trip = trips.get(row);
		switch (col) {
		case TRIP_NAME_COLUMN:
			return trip.getTripName();
		case TRIP_ID_COLUMN:
			return trip.getTripId();
		case START_COLUMN:
			return trip.getStartDate();
		case END_COLUMN:
			return trip.getEndDate();
		case TRAVEL_TYPE_COLUMN:
			return trip.getTransportType();
		case TRAVEL_DEPARTURE_COLUMN:
			return trip.getTransportDeparture();
		case TRAVEL_ARRIVAL_COLUMN:
			return trip.getTransportArrival();
		case ACCOMMODATION_COLUMN:
			return trip.getAccommodation();
		case ACCOMMODATION_ARRIVAL_COLUMN:
			return trip.getAccommodationArrival();
		case ACCOMMODATION_DEPARTURE_COLUMN:
			return trip.getAccommodationDeparture();
		case ENTRANCE_FEE_COLUMN:
			return trip.getEntranceFee();
		case SUNDRY_FEE_COLUMN:
			return trip.getSundryFee();
		case VENUE_COLUMN:
			return trip.getVenue();
		case APPROVAL_REQUIRED_COLUMN:
			return trip.isApprovalRequired();
		case TRIP_TYPE_COLUMN:
			return trip.getTripType();
		default:
			return null;
		}
	}

	// Get the name of the column
	public String getColumnName(int col) {
		return columns[col];
	}
}
