/**
 * 
 */
package TableModels;

import Models.StudentTrip;
import Queries.TripQueries;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class StudentTripTableModel extends StudentTableModel {

	public static final int PAID_COLUMN = 3;
	public static final int AUTH_COLUMN = 4;
	public static final int ID_COLUMN = 5;

	private StudentTrip[] studentTrips;

	public StudentTripTableModel(StudentTrip[] studentTripList) {
		super(studentTripList);
		studentTrips = studentTripList;

		columns = new String[] { "First Name", "Last Name", "Mobile Number", "Paid", "Authorised" };
	}

	/**
	 * get the values for the table
	 */
	@Override
	public Object getValueAt(int row, int col) {

		StudentTrip student = studentTrips[row];
		switch (col) {
		case PAID_COLUMN:
			return student.getPaid();
		case AUTH_COLUMN:
			return student.getAuthorisation();
		case ID_COLUMN:
			return student.getStudentTripId();
		default:
			return super.getValueAt(row, col);
		}
	}

	/**
	 * Updates the paid and authorised values in the db
	 */
	public void setValueAt(Object value, int row, int col) {

		TripQueries tripQueries = new TripQueries();
		int studentTripId = studentTrips[row].getStudentTripId();
				
		switch (col) {
		case PAID_COLUMN:
			studentTrips[row].setPaid((Boolean) (value));
			tripQueries.setPaid(studentTripId, (Boolean) value);
			break;
		case AUTH_COLUMN:
			studentTrips[row].setAuthorisation((Boolean) (value));
			tripQueries.setAuthorisation(studentTripId, (Boolean) value);
			break;
		}
	}

	/**
	 * See which columns can be edited
	 */
	public boolean isCellEditable(int row, int col) {

		switch (col) {
		case AUTH_COLUMN:
			return true;
		case PAID_COLUMN:
			return true;
		default:
			return false;
		}
	}

	/**
	 * gets the type of data within the table to display it correctly - boolean
	 * as checkbox
	 */
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
