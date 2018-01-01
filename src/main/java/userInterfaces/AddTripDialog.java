/**
 * 
 */
package userInterfaces;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Models.Trip;
import Queries.TripQueries;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class AddTripDialog extends JDialog {

	private String tripType;
	// Interface variables
	private final JPanel tripTypePanel = new JPanel();
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel buttonPanel;
	private JRadioButton rdbtnDayExternal;
	private JRadioButton rdbtnResidentialTeacher;
	private JRadioButton rdbtnResidentialExternal;
	private JLabel lblTripType;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnDayTeacher;
	private JPanel tripInputPanel;

	/**
	 * Constructor
	 */
	public AddTripDialog() {

		initComponents();
		eventHandller();
	}

	/**
	 * Create the interface.
	 */
	public void initComponents() {

		// Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Displays the dialog in front of any others
		setModalityType(ModalityType.APPLICATION_MODAL);

		// title bar
		setTitle("New Trip");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddTripDialog.class.getResource("/resources/add.png")));

		// Layout
		setBounds(100, 100, 431, 516);
		tripTypePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			// combo box label
			lblTripType = new JLabel("Trip Type:");
			lblTripType.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		{
			// button layout
			buttonPanel = new JPanel();
			{
				// Add button
				btnAdd = new JButton("");
				btnAdd.setIcon(new ImageIcon(AddTripDialog.class.getResource("/resources/add.png")));
				btnAdd.setActionCommand("OK");
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				// cancel button
				btnCancel = new JButton("");
				btnCancel.setIcon(new ImageIcon(AddTripDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
			}
		}
		// Create the four radio buttons and add them to a group together
		{
			rdbtnDayTeacher = new JRadioButton("Day - Teacher Organised");
			// Select this as default
			rdbtnDayTeacher.setSelected(true);
			buttonGroup.add(rdbtnDayTeacher);
		}
		{
			rdbtnDayExternal = new JRadioButton("Day - External Provider");
			buttonGroup.add(rdbtnDayExternal);
		}
		{
			rdbtnResidentialTeacher = new JRadioButton("Residential - Teacher Organised");
			buttonGroup.add(rdbtnResidentialTeacher);
		}
		{
			rdbtnResidentialExternal = new JRadioButton("Residential - External Provider");
			buttonGroup.add(rdbtnResidentialExternal);
		}

		// Apply a group layout
		GroupLayout gl_tripTypePanel = new GroupLayout(tripTypePanel);
		gl_tripTypePanel.setHorizontalGroup(gl_tripTypePanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_tripTypePanel.createSequentialGroup().addContainerGap().addComponent(lblTripType).addGap(28)
						.addGroup(gl_tripTypePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnResidentialExternal).addComponent(rdbtnDayExternal)
								.addComponent(rdbtnDayTeacher).addComponent(rdbtnResidentialTeacher))
						.addContainerGap(153, Short.MAX_VALUE)));
		gl_tripTypePanel.setVerticalGroup(gl_tripTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tripTypePanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_tripTypePanel.createParallelGroup(Alignment.BASELINE).addComponent(lblTripType)
								.addComponent(rdbtnDayTeacher))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnDayExternal)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnResidentialTeacher)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnResidentialExternal)
						.addContainerGap(34, Short.MAX_VALUE)));
		tripTypePanel.setLayout(gl_tripTypePanel);

		// Create the trip input panel to hold the required input panels
		tripInputPanel = new JPanel();
		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						groupLayout
								.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup().addContainerGap().addComponent(
														buttonPanel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
										.addComponent(tripTypePanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup().addGap(1)
														.addComponent(tripInputPanel, 0, 0, Short.MAX_VALUE)))
								.addGap(7)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(tripTypePanel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tripInputPanel, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)));

		// Apply a box layout to the input panel, this will display the added
		// panels in the required way
		tripInputPanel.setLayout(new BoxLayout(tripInputPanel, BoxLayout.Y_AXIS));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup().addContainerGap(326, Short.MAX_VALUE)
						.addComponent(btnAdd).addGap(5).addComponent(btnCancel).addGap(5)));
		gl_buttonPanel.setVerticalGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup().addGap(5).addGroup(gl_buttonPanel
						.createParallelGroup(Alignment.LEADING).addComponent(btnAdd).addComponent(btnCancel))));
		buttonPanel.setLayout(gl_buttonPanel);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Handles events.
	 */
	public void eventHandller() {

		// Cancel button clicked
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Create the following panels:
		final TripPanel tripPanel = new TripPanel();
		final TravelPanel travelPanel = new TravelPanel();
		final AllFeesPanel allFeesPanel = new AllFeesPanel();
		final VenuePanel venuePanel = new VenuePanel();
		final EntranceFeesPanel entranceFeePanel = new EntranceFeesPanel();
		final AccommodationPanel accommodationPanel = new AccommodationPanel();

		// Add the panels for the defualt - day, teacher organised trip
		tripInputPanel.add(tripPanel);
		tripInputPanel.add(travelPanel);
		tripInputPanel.add(allFeesPanel);
		tripInputPanel.add(venuePanel);
		//Set the default trip type 
		tripType = "DayTeacher";

		// Make everything fit into the JDialog
		pack();

		// The residential teacher organised radio button is selected
		rdbtnResidentialTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Set the trip type
				tripType = "ResidentialTeacher";

				// Make sure the panel is empty
				tripInputPanel.removeAll();

				// Add the following panels to the input panel:

				tripInputPanel.add(tripPanel);
				tripInputPanel.add(travelPanel);
				tripInputPanel.add(allFeesPanel);
				tripInputPanel.add(venuePanel);
				tripInputPanel.add(accommodationPanel);

				// Make everything fit into the JDialog
				pack();
			}
		});

		// The day teacher organised radio button is selected
		rdbtnDayTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Set the trip type
				tripType = "DayTeacher";

				// Make sure the panel is empty
				tripInputPanel.removeAll();

				// Add the following panels to the input panel:
				tripInputPanel.add(tripPanel);
				tripInputPanel.add(travelPanel);
				tripInputPanel.add(allFeesPanel);
				tripInputPanel.add(venuePanel);

				// Make everything fit into the JDialog
				pack();
			}
		});

		// The residential externally organised radio button is selected
		rdbtnResidentialExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Set the trip type
				tripType = "ResidentialExternal";

				// Make sure the panel is empty
				tripInputPanel.removeAll();

				// Add the following panels to the input panel:
				tripInputPanel.add(tripPanel);
				tripInputPanel.add(travelPanel);
				tripInputPanel.add(entranceFeePanel);

				// Make everything fit into the JDialog
				pack();
			}
		});

		// The day externally organised radio button is selected
		rdbtnDayExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Set the trip type
				tripType = "DayExternal";

				// Make sure the panel is empty
				tripInputPanel.removeAll();

				// Add the following panels to the input panel:
				tripInputPanel.add(tripPanel);
				tripInputPanel.add(travelPanel);
				tripInputPanel.add(entranceFeePanel);

				// Make everything fit into the JDialog
				pack();
			}
		});

		// Add button is clicked
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Create a new trip
				Trip newTrip = new Trip();

				// Error message to be populated if there is a verification
				// issue
				String errorMessage = "";

				// Add the trip to the db...
				// Get the values from each text box
				String tripName = tripPanel.getTripName();
				String startDate = tripPanel.getStartDate();
				String endDate = tripPanel.getEndDate();
				String travelType = travelPanel.getTravelType();
				String travelDeparture = travelPanel.getTravelDeparture();
				String travelArrival = travelPanel.getTravelArival();

				// Verify this data
				newTrip.setTransportType(travelType);
				newTrip.setTripType(tripType);
				
				if (!newTrip.setTripName(tripName)) {
					errorMessage = "Name field is empty";
				}

				if (!newTrip.setStartDate(startDate)) {
					errorMessage = "Start date field is empty";
				}

				if (!newTrip.setEndDate(endDate)) {
					errorMessage = "End date field is empty";
				}

				if (!newTrip.setTransportDeparture(travelDeparture)) {
					errorMessage = "Transport departure time is empty";
				}

				if (!newTrip.setTransportArrival(travelArrival)) {
					errorMessage = "Transport arrival time is empty";
				}

				// Get the values depending on the panels being show, i.e. the
				// trip type and then verify that data
				if (tripType.equals("ResidentialTeacher")) {
					String venue = venuePanel.getVenue();
					String accommodation = accommodationPanel.getAccommodation();
					String accommodationArrival = accommodationPanel.getAccommodationArrival();
					String accommodationDeparture = accommodationPanel.getAccommodationDeparture();

					newTrip.setApprovalRequired(true);
					
					try
					{
						Double sundryFee = allFeesPanel.getSundryFee();
												
						if (!newTrip.setEntranceFee(sundryFee)) {
							errorMessage = "Sundry fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Sundry fee needs to be a number";
					}
					
					try
					{
						Double entranceFee = allFeesPanel.getEntranceFee();
												
						if (!newTrip.setEntranceFee(entranceFee)) {
							errorMessage = "Entrance fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Entrance fee needs to be a number";
					}

					if (!newTrip.setVenue(venue)) {
						errorMessage = "Venue is empty";
					}
					
					if(!newTrip.setAccommodation(accommodation)){
						errorMessage = "Accommodation is empty";
					}
					
					if(!newTrip.setAccommodationArrival(accommodationArrival)){
						errorMessage = "Accommodation arrival is empty";
					}
					
					if(!newTrip.setAccommodationDeparture(accommodationDeparture)){
						errorMessage = "Accommodation departure is empty";
					}

				} else if (tripType.equals("DayTeacher")) {

					newTrip.setApprovalRequired(false);
					String venue = venuePanel.getVenue();

					try
					{
						Double sundryFee = allFeesPanel.getSundryFee();
												
						if (!newTrip.setEntranceFee(sundryFee)) {
							errorMessage = "Sundry fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Sundry fee needs to be a number";
					}
					
					try
					{
						Double entranceFee = allFeesPanel.getEntranceFee();
						
						if (!newTrip.setEntranceFee(entranceFee)) {
							errorMessage = "Entrance fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Entrance fee needs to be a number";
					}
					
					if (!newTrip.setVenue(venue)) {
						errorMessage = "Venue is empty";
					}

				} else if (tripType.equals("ResidentialExternal")) {
					try
					{
						Double entranceFee = entranceFeePanel.getEntranceFee();
												
						if (!newTrip.setEntranceFee(entranceFee)) {
							errorMessage = "Entrance fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Entrance fee needs to be a number";
					}
					
					newTrip.setApprovalRequired(true);

				} else if (tripType.equals("DayExternal")) {
					
					try
					{
						Double entranceFee = entranceFeePanel.getEntranceFee();
												
						if (!newTrip.setEntranceFee(entranceFee)) {
							errorMessage = "Entrance fee is empty";
						}
					}
					catch (NumberFormatException e)
					{
						errorMessage = "Entrance fee needs to be a number";
					}

					newTrip.setApprovalRequired(false);

				}
				
				// If the data is verified
				if (errorMessage.isEmpty()) {
					// Add the trip to the db
					new TripQueries().addTrip(newTrip);
					// Update the display
					TripsTabPanel.updateTripTable();
					
					// Show a verification dialog
					JOptionPane.showMessageDialog(null, "Trip added succesfully.");

					// close the view
					dispose();
				} else {
				// Show the invalid data dialog
				InvalidDataDialog invalidDialog = new InvalidDataDialog();
				invalidDialog.lblInfoText.setText(errorMessage);
				invalidDialog.setVisible(true);
			}
			}
		});
	}
}
