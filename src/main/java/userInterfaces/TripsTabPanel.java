/**
 * 
 */
package userInterfaces;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class TripsTabPanel extends JPanel {

	private JLabel lblTripStartDateFromDb;
	private JLabel lblTripEndDateFromDb;
	private JLabel lblTripNameFromDb;
	private JTable studentsTable;
	private JButton btnAddTrip;
	private JButton btnRemoveTrip;
	private JButton btnAddStudent;
	private JButton btnRemoveStudent;
	private JLabel lblTripApprovalFromDb;
	private JLabel lblTripEntranceFeeFromDb;
	private JLabel lblTripSundryFeeFromDb;
	private JLabel lblTripTransportTypeFromDb;
	private JLabel lblTripTransportDepartureFromDb;
	private JLabel lblTripTransportArrivalFromDb;
	private JLabel lblTripVenueFromDb;
	private JLabel lblTripHotelFromDb;
	private JLabel lblHotelArrivalFromDb;
	private JLabel lblHotelDepartureFromDb;

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

		// ScrollPane for the content of the tripTree
		JScrollPane spTrips = new JScrollPane();

		//Create the add trip button and set its image
		btnAddTrip = new JButton("");
		btnAddTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));
		
		// Create the remove trip button and set its image 
		btnRemoveTrip = new JButton("");
		btnRemoveTrip.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));
		
		//Create the add student button and set its image
		btnAddStudent = new JButton("");
		btnAddStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/add.png")));

		//Create the remove student button and set its image 
		btnRemoveStudent = new JButton("");
		btnRemoveStudent.setIcon(new ImageIcon(TripsTabPanel.class.getResource("/resources/remove.png")));

		//Create the panel to display the trip details
		JPanel panelTripDetails = new JPanel();
		panelTripDetails.setBorder(null);

		//Create the students table
		studentsTable = new JTable();

		// The group layout for the pane. This set the layout for anything added to the pane
		// along with a position or alignment
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(spTrips, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelTripDetails, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddTrip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveTrip)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddStudent)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveStudent))
						.addComponent(studentsTable, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(studentsTable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(panelTripDetails, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
						.addComponent(spTrips, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnAddTrip)
							.addComponent(btnRemoveTrip))
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnRemoveStudent)
							.addComponent(btnAddStudent)))
					.addContainerGap())
		);
		panelTripDetails.setLayout(null);

		// Labels for displaying trip details
			// Names
		JLabel lblTripName = new JLabel("Trip Name:");
		lblTripName.setBounds(10, 30, 60, 14);
		panelTripDetails.add(lblTripName);
		lblTripName.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripNameFromDb = new JLabel("The name of the trip....");
		lblTripNameFromDb.setBounds(76, 30, 223, 14);
		panelTripDetails.add(lblTripNameFromDb);

			// Hotel
		JLabel lblTripHotel = new JLabel("Hotel:");
		lblTripHotel.setBounds(10, 265, 33, 14);
		panelTripDetails.add(lblTripHotel);
		lblTripHotel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTripHotelDepartureFromDb = new JLabel("Departure:");
		lblTripHotelDepartureFromDb.setBounds(53, 305, 61, 14);
		panelTripDetails.add(lblTripHotelDepartureFromDb);
		lblTripHotelDepartureFromDb.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblHotelDepartureFromDb = new JLabel("13/12/2012 12:00");
		lblHotelDepartureFromDb.setBounds(120, 305, 179, 14);
		panelTripDetails.add(lblHotelDepartureFromDb);

		JLabel lblTripHotelArrivalFromDb = new JLabel("Arrival:");
		lblTripHotelArrivalFromDb.setBounds(53, 285, 61, 14);
		panelTripDetails.add(lblTripHotelArrivalFromDb);
		lblTripHotelArrivalFromDb.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblHotelArrivalFromDb = new JLabel("12/12/2012 17:00");
		lblHotelArrivalFromDb.setBounds(120, 285, 177, 14);
		panelTripDetails.add(lblHotelArrivalFromDb);

		lblTripHotelFromDb = new JLabel("The Dalmeny, Preston");
		lblTripHotelFromDb.setBounds(64, 265, 235, 14);
		panelTripDetails.add(lblTripHotelFromDb);

			// Venue
		JLabel lblTripVenue = new JLabel("Venue:");
		lblTripVenue.setBounds(10, 231, 38, 14);
		panelTripDetails.add(lblTripVenue);
		lblTripVenue.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripVenueFromDb = new JLabel("The place, Somerset, Ba213UQ");
		lblTripVenueFromDb.setBounds(54, 231, 245, 14);
		panelTripDetails.add(lblTripVenueFromDb);

			// Start date
		JLabel lblTripStartDate = new JLabel("Start Date:");
		lblTripStartDate.setBounds(10, 60, 62, 14);
		panelTripDetails.add(lblTripStartDate);
		lblTripStartDate.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripStartDateFromDb = new JLabel("12/12/2012");
		lblTripStartDateFromDb.setBounds(76, 60, 81, 14);
		panelTripDetails.add(lblTripStartDateFromDb);

			// End Date
		JLabel lblTripEndDate = new JLabel("End Date:");
		lblTripEndDate.setBounds(153, 60, 53, 14);
		panelTripDetails.add(lblTripEndDate);
		lblTripEndDate.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripEndDateFromDb = new JLabel("12/12/2012");
		lblTripEndDateFromDb.setBounds(208, 60, 91, 14);
		panelTripDetails.add(lblTripEndDateFromDb);

			// Fees
		JLabel lblTripFees = new JLabel("Trip Fees");
		lblTripFees.setBounds(10, 85, 51, 14);
		panelTripDetails.add(lblTripFees);
		lblTripFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTripEntranceFee = new JLabel("Entrance:");
		lblTripEntranceFee.setBounds(53, 105, 53, 14);
		panelTripDetails.add(lblTripEntranceFee);
		lblTripEntranceFee.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTripSundryFee = new JLabel("Sundry:");
		lblTripSundryFee.setBounds(53, 125, 43, 14);
		panelTripDetails.add(lblTripSundryFee);
		lblTripSundryFee.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripSundryFeeFromDb = new JLabel("£10");
		lblTripSundryFeeFromDb.setBounds(112, 125, 187, 14);
		panelTripDetails.add(lblTripSundryFeeFromDb);

		lblTripEntranceFeeFromDb = new JLabel("£1000");
		lblTripEntranceFeeFromDb.setBounds(112, 105, 30, 14);
		panelTripDetails.add(lblTripEntranceFeeFromDb);

			// Transport
		JLabel lblTripTransport = new JLabel("Transport");
		lblTripTransport.setBounds(10, 150, 56, 14);
		panelTripDetails.add(lblTripTransport);
		lblTripTransport.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTripTransportDeparture = new JLabel("Departure:");
		lblTripTransportDeparture.setBounds(53, 186, 61, 14);
		panelTripDetails.add(lblTripTransportDeparture);
		lblTripTransportDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTripTransportType = new JLabel("Type:");
		lblTripTransportType.setBounds(53, 168, 31, 14);
		panelTripDetails.add(lblTripTransportType);
		lblTripTransportType.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripTransportTypeFromDb = new JLabel("Bus.....");
		lblTripTransportTypeFromDb.setBounds(120, 168, 179, 14);
		panelTripDetails.add(lblTripTransportTypeFromDb);

		lblTripTransportDepartureFromDb = new JLabel("15:00");
		lblTripTransportDepartureFromDb.setBounds(120, 186, 179, 14);
		panelTripDetails.add(lblTripTransportDepartureFromDb);

		JLabel lblTripTransportArrival = new JLabel("Arrival:");
		lblTripTransportArrival.setBounds(53, 206, 61, 14);
		panelTripDetails.add(lblTripTransportArrival);
		lblTripTransportArrival.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTripTransportArrivalFromDb = new JLabel("16:00");
		lblTripTransportArrivalFromDb.setBounds(120, 206, 179, 14);
		panelTripDetails.add(lblTripTransportArrivalFromDb);

			//Approvals
		JLabel lblTripApproval = new JLabel("Approval Required:");
		lblTripApproval.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTripApproval.setBounds(10, 330, 108, 14);
		panelTripDetails.add(lblTripApproval);

		lblTripApprovalFromDb = new JLabel("Yes/No");
		lblTripApprovalFromDb.setBounds(120, 330, 46, 14);
		panelTripDetails.add(lblTripApprovalFromDb);

		// The trips tree
		JTree treeTrips = new JTree();
		spTrips.setViewportView(treeTrips);
		treeTrips.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Current Trips") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("January");
				node_1.add(new DefaultMutableTreeNode("Ice Skating "));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("February");
				node_1.add(new DefaultMutableTreeNode("Walking"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("March\t");
				node_1.add(new DefaultMutableTreeNode("Swimming"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("April");
				node_1.add(new DefaultMutableTreeNode("Zoo"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("May");
				node_1.add(new DefaultMutableTreeNode("Paris"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("June\t");
				node_1.add(new DefaultMutableTreeNode("London"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("July");
				node_1.add(new DefaultMutableTreeNode("Weymouth"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("August");
				node_1.add(new DefaultMutableTreeNode("Park"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("September");
				node_1.add(new DefaultMutableTreeNode("Aquarium"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("October");
				node_1.add(new DefaultMutableTreeNode("Monkey World"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("November");
				node_1.add(new DefaultMutableTreeNode("Longleat"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("December");
				node_1.add(new DefaultMutableTreeNode("Lap Land"));
				add(node_1);
			}
		}));
		
		//Applying group layout
		setLayout(groupLayout);
	}
	
	public void eventHandler(){ 
		
		//For when the add trip button is clicked
		btnAddTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TripTypeDialog tripTypeDialog = new TripTypeDialog();
				tripTypeDialog.setModal(true);
				tripTypeDialog.setVisible(true);
			}
		});
		
		//For when the add student button is clicked
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGroupToTripDialog addGroupDialog = new AddGroupToTripDialog(); 
				addGroupDialog.setModal(true);
				addGroupDialog.setVisible(true);
			}
		});
	}
}