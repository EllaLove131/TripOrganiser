/**
 * 
 */
package userInterfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import Models.Trip;
import Queries.TripQueries;
import TableModels.TripTableModel;
import javax.swing.BoxLayout;

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
		btnAddTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));

		// Create the remove trip button and set its image
		btnRemoveTrip = new JButton("");
		btnRemoveTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));

		// Create the add student button and set its image
		btnAddStudent = new JButton("");
		btnAddStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));

		// Create the remove student button and set its image
		btnRemoveStudent = new JButton("");
		btnRemoveStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));

		// Create the panel to display the trip details
		displayPanel = new JPanel();
		displayPanel.setBorder(null);

		// Create the scrollPane for the content of the tripTable
		JScrollPane spTrips = new JScrollPane();

		JScrollPane scrollPane = new JScrollPane();

		// The group layout for the pane. This set the layout for anything added
		// to the pane
		// along with a position or alignment
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnAddTrip)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRemoveTrip))
								.addComponent(spTrips, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE).addGroup(
										groupLayout.createSequentialGroup().addComponent(btnAddStudent)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														btnRemoveStudent)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(spTrips, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
										.addComponent(displayPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(13).addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnAddTrip)
						.addComponent(btnRemoveTrip).addComponent(btnRemoveStudent).addComponent(btnAddStudent))
				.addContainerGap()));
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

		// Query the db to get the data to fill the rows and add it to an array
		// list
		TripQueries tripQueries = new TripQueries();
		ArrayList<Trip> trips = tripQueries.getTrips();
		// Create the table model for trips
		TripTableModel tripTableModel = new TripTableModel(trips);
		// Create the table using the table model
		tblTrips = new JTable(tripTableModel);

		// Add the trip table to the scroll panel
		spTrips.setViewportView(tblTrips);

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
				// Make sure the panel is empty
				displayPanel.removeAll();

				// Get the type of trip selected and it's ID
				String tripType = getTripType();

				// TOOD update the student table

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
				boolean approval = (Boolean) tblTrips.getModel().getValueAt(selectedRow,
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

	// /**
	// * Gets the trip Id for the selected trip in the trip table
	// * @return tripId
	// */
	// public static Integer getTripId() {
	// // Get selected trip row from the selected row
	// int selectedRow = tblTrips.getSelectedRow();
	//
	// // Check for no row selected.
	// if (selectedRow == -1) {
	// selectedRow = 0;
	// }
	// Integer tripId = (Integer) tblTrips.getModel().getValueAt(selectedRow,
	// TripTableModel.TRIP_ID_COLUMN);
	//
	// return tripId;
	//
	// }
}