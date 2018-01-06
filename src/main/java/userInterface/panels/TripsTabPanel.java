/**
 * 
 */
package userInterface.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Models.StudentTrip;
import Models.Trip;
import Queries.TripQueries;
import TableModels.StudentTableModel;
import TableModels.StudentTripTableModel;
import TableModels.TripTableModel;
import userInterface.dialogs.AddGroupToTripDialog;
import userInterface.dialogs.AddTripDialog;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class TripsTabPanel extends JPanel {
	private JButton btnAddTrip;
	private JButton btnRemoveTrip;
	private JButton btnAddStudent;
	private JButton btnRemoveStudent;
	private static JTable tblTrips;
	private JPanel displayPanel;
	private static JTable tblStudents;

	/**
	 * Create the panel.
	 */
	public TripsTabPanel() {

		initComponents();
		eventHandler();
	}

	/**
	 * Initialise components.
	 */
	private void initComponents() {

		// Create the add trip button and set its image
		btnAddTrip = new JButton("");
		btnAddTrip.setToolTipText("Add a new trip");
		btnAddTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));

		// Create the remove trip button and set its image
		btnRemoveTrip = new JButton("");
		btnRemoveTrip.setToolTipText("Remove your selected trip");
		btnRemoveTrip.setEnabled(false);
		btnRemoveTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));

		// Create the add student button and set its image
		btnAddStudent = new JButton("");
		btnAddStudent.setToolTipText("Add students to the selected trip");
		btnAddStudent.setEnabled(false);
		btnAddStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));

		// Create the remove student button and set its image
		btnRemoveStudent = new JButton("");
		btnRemoveStudent.setToolTipText("Remove the selected student from the selected trip");
		btnRemoveStudent.setEnabled(false);
		btnRemoveStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));

		// Create the panel to display the trip details
		displayPanel = new JPanel();
		displayPanel.setToolTipText("The details of the selected trip");
		displayPanel.setBorder(null);

		// Create the scrollPane for the content of the tripTable
		JScrollPane spTrips = new JScrollPane();

		JScrollPane spStudents = new JScrollPane();

		// The group layout for the pane. This set the layout for anything added
		// to the pane
		// along with a position or alignment
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddTrip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveTrip))
						.addComponent(spTrips, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(btnAddStudent)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveStudent))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(spTrips, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddTrip)
						.addComponent(btnRemoveTrip)
						.addComponent(btnRemoveStudent)
						.addComponent(btnAddStudent))
					.addContainerGap())
		);

		// Give the display pane a y-axis box layout
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

		// Trips Table
		// Query the db to get the data to fill the rows and add it to an array
		// list
		TripQueries tripQueries = new TripQueries();
		ArrayList<Trip> trips = tripQueries.getTrips();
		// Create the table model for trips
		TripTableModel tripTableModel = new TripTableModel(trips);
		// Create the table using the table model
		tblTrips = new JTable(tripTableModel);
		tblTrips.setToolTipText("The avaliable trips");
		// Add the trip table to the scroll panel
		spTrips.setViewportView(tblTrips);

		// Students Table
		// Query the db to get the data to fill the rows and add it to an array
		// list
		Integer tripId = getTripId();
		ArrayList<StudentTrip> studentTrips = new ArrayList<StudentTrip>();

		// If there are any trips
		if (tripId != null) {
			studentTrips = tripQueries.getStudentsFromTrip(tripId.intValue());
		}
		// Create the table model for trips
		StudentTripTableModel studentTripTableModel = 
				new StudentTripTableModel(studentTrips.toArray(new StudentTrip[studentTrips.size()]));
		// Create the table using the table model
		tblStudents = new JTable(studentTripTableModel);
		tblStudents.setToolTipText("The students attending the selected trip");

		// Add the students table to the scroll panel
		spStudents.setViewportView(tblStudents);

		// Applying group layout
		setLayout(groupLayout);
	}

	public void eventHandler() {

		// For when the add trip button is clicked
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTripDialog tripTypeDialog = new AddTripDialog();
				tripTypeDialog.setVisible(true);
			}
		});

		// For when the add student button is clicked
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGroupToTripDialog addGroupDialog = new AddGroupToTripDialog();
				addGroupDialog.setVisible(true);
			}
		});

		// When a selection is made in the trips table
		tblTrips.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				// set the following buttons to enabled:
				btnAddStudent.setEnabled(true);
				btnRemoveTrip.setEnabled(true);

				// Make sure the panel is empty
				displayPanel.removeAll();

				// Get the type of trip selected and it's ID
				String tripType = getTripType();

				// Create the panels for data to be displayed within
				TripDisplayPanel tripDisplayPanel = new TripDisplayPanel();
				AccommodationDisplayPanel accommodationPanel = new AccommodationDisplayPanel();
				AllFeesDisplayPanel allFeesPanel = new AllFeesDisplayPanel();
				EntranceFeesDisplayPanel entranceFeesPanel = new EntranceFeesDisplayPanel();
				VenueDisplayPanel venuePanel = new VenueDisplayPanel();

				// Always have this panel added to the view
				displayPanel.add(tripDisplayPanel);
				// Set the text display for the trip inside of this panel
				int selectedRow = tblTrips.getSelectedRow();

				// Check for no row selected.
				if (selectedRow == -1) {
					selectedRow = 0;
				}
				
				// Get the Data to populate the display with (For all trip
				// types)
				String tripName = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.TRIP_NAME_COLUMN);
				String tripStart = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.START_COLUMN);
				String tripEnd = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.END_COLUMN);
				String travelType = (String) tblTrips.getModel().getValueAt(selectedRow,
						TripTableModel.TRAVEL_TYPE_COLUMN);
				String travelDeparture = (String) tblTrips.getModel().getValueAt(selectedRow,
						TripTableModel.TRAVEL_DEPARTURE_COLUMN);
				String travelArrival = (String) tblTrips.getModel().getValueAt(selectedRow,
						TripTableModel.TRAVEL_ARRIVAL_COLUMN);
				Boolean approval = (Boolean) tblTrips.getModel().getValueAt(selectedRow,
						TripTableModel.APPROVAL_REQUIRED_COLUMN);

				// Populate the display with the given data (For all trip types)
				tripDisplayPanel.setNameLabel(tripName);
				tripDisplayPanel.setTripTypeLabel(tripType);
				tripDisplayPanel.setStartLabel(tripStart);
				tripDisplayPanel.setEndLabel(tripEnd);
				tripDisplayPanel.setTravelTypeLabel(travelType);
				tripDisplayPanel.setTravelDepartureLabel(travelDeparture);
				tripDisplayPanel.setTravelArrivalLabel(travelArrival);
				tripDisplayPanel.setApprovalLabel(approval);

				// Add panels depending on the trip type selected
				// then set the text inside of them
				if (tripType.equals("DayTeacher")) {
					displayPanel.add(allFeesPanel);
					displayPanel.add(venuePanel);

					// Get the Data to populate the display with
					Double entranceFee = (Double) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ENTRANCE_FEE_COLUMN);
					Double sundryFee = (Double) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.SUNDRY_FEE_COLUMN);
					String venue = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.VENUE_COLUMN);

					// Populate the display with the given data
					allFeesPanel.setEntranceFeeLabel(entranceFee);
					allFeesPanel.setSundryFeeLabel(sundryFee);
					venuePanel.setVenueLabel(venue);
				}
				if (tripType.equals("DayExternal") || tripType.equals("ResidentialExternal")) {
					displayPanel.add(entranceFeesPanel);

					// Get the Data to populate the display with
					Double entranceFee = (Double) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ENTRANCE_FEE_COLUMN);

					// Populate the display with the given data
					entranceFeesPanel.setEntranceFeeLabel(entranceFee);
				}
				if (tripType.equals("ResidentialTeacher")) {
					displayPanel.add(allFeesPanel);
					displayPanel.add(venuePanel);
					displayPanel.add(accommodationPanel);

					// Get the Data to populate the display with
					Double entranceFee = (Double) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ENTRANCE_FEE_COLUMN);
					Double sundryFee = (Double) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.SUNDRY_FEE_COLUMN);
					String venue = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.VENUE_COLUMN);
					String accommodation = (String) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ACCOMMODATION_COLUMN);
					String accommodationArrival = (String) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ACCOMMODATION_ARRIVAL_COLUMN);
					String accommodationDeparture = (String) tblTrips.getModel().getValueAt(selectedRow,
							TripTableModel.ACCOMMODATION_DEPARTURE_COLUMN);

					// Populate the display with the given data
					allFeesPanel.setEntranceFeeLabel(entranceFee);
					allFeesPanel.setSundryFeeLabel(sundryFee);
					venuePanel.setVenueLabel(venue);
					accommodationPanel.setAccommodationLabel(accommodation);
					accommodationPanel.setAccommodationArrivalLabel(accommodationArrival);
					accommodationPanel.setAccommodationDepartureLabel(accommodationDeparture);
				}
				// Makes the panel display update
				displayPanel.revalidate();
				displayPanel.repaint();

				// Update the students table
				updateStudentTripTable();
			}
		});

		// When a selection is made in the trips table
		tblStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// Set the button to enabled
				btnRemoveStudent.setEnabled(true);
			}
		});

		// When the remove student button is clicked
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Remove the selected student from the trip
				int studentId = getStudentId();
				new TripQueries().removeStudentFromTrip(studentId);

				// Update the table
				updateStudentTripTable();
			}
		});

		// When the remove trip button is clicked
		btnRemoveTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Remove the trip from the db 
				int tripId = getTripId();
				new TripQueries().removeTrip(tripId);
				
				//Update the table
				updateTripTable();
				updateStudentTripTable();
			}
		});
	}

	/**
	 * Updates the trip table
	 */
	public static void updateTripTable() {
		TripQueries tripQueries = new TripQueries();
		ArrayList<Trip> trips = tripQueries.getTrips();
		TripTableModel tripTableModel = new TripTableModel(trips);
		tblTrips.setModel(tripTableModel);
	}

	/**
	 * Gets the type of trip that is selected in the trip table
	 * 
	 * @return tripType
	 */
	public static String getTripType() {
		// Get selected trip row from the selected row
		int selectedRow = tblTrips.getSelectedRow();

		// Check for no row selected.
		if (selectedRow == -1) {
			selectedRow = 0;
		}
		String tripType = (String) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.TRIP_TYPE_COLUMN);

		return tripType;
	}

	/**
	 * Get the ID of the selected trip
	 * 
	 * @return tripId
	 */
	public static Integer getTripId() {

		// get the selected trip from
		int selectedRow = tblTrips.getSelectedRow();

		// Check for no row selected.
		if (selectedRow == -1) {
			selectedRow = 0;
		}

		Integer tripId = (Integer) tblTrips.getModel().getValueAt(selectedRow, TripTableModel.TRIP_ID_COLUMN);

		return tripId;
	}

	/**
	 * Get the ID of the selected student
	 * 
	 * @return studentId
	 */
	public static Integer getStudentId() {

		// get the selected trip from
		int selectedRow = tblStudents.getSelectedRow();

		// Check for no row selected.
		if (selectedRow == -1) {
			selectedRow = 0;
		}

		Integer studentId = (Integer) tblStudents.getModel().getValueAt(selectedRow,
				StudentTableModel.STUDENT_ID_COLUMN);

		return studentId;
	}

	/**
	 * Update the student table
	 */
	public static void updateStudentTripTable() {
		TripQueries tripQueries = new TripQueries();
		int tripId = getTripId();
		ArrayList<StudentTrip> studentTrips = tripQueries.getStudentsFromTrip(tripId);
		StudentTableModel studentTableModel =
				new StudentTripTableModel(studentTrips.toArray(new StudentTrip[studentTrips.size()]));
		tblStudents.setModel(studentTableModel);
	}
}