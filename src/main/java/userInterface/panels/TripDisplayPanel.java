/**
 * 
 */
package userInterface.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Ella Love
 *
 *         Panel used for displaying information relevant to all trip types,
 *         including name, start date, end date, travel information and if
 *         approval is required. Allows for the setting of values within the
 *         text labels
 */
@SuppressWarnings("serial")
public class TripDisplayPanel extends JPanel {
	private JLabel lblApprovalDb;
	private JLabel lblArrivalDb;
	private JLabel lblDepartureDb;
	private JLabel lblTransportTypeDb;
	private JLabel lblEndDb;
	private JLabel lblStartDb;
	private JLabel lblTypeDb;
	private JLabel lblNameDb;

	/**
	 * Create the panel.
	 */
	public TripDisplayPanel() {

		// Create the labels
		JLabel lblName = new JLabel("Trip Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNameDb = new JLabel("");

		JLabel lblStart = new JLabel("Start Date:");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblStartDb = new JLabel("");

		JLabel lblEnd = new JLabel("End Date:");
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblEndDb = new JLabel("");

		JLabel lblTransport = new JLabel("Transport");
		lblTransport.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblTransportType = new JLabel("Type:");
		lblTransportType.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblArrivalDb = new JLabel("");

		lblDepartureDb = new JLabel("");

		lblTransportTypeDb = new JLabel("");

		JLabel lblApproval = new JLabel("Approval Required:");
		lblApproval.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblApprovalDb = new JLabel("");

		JLabel lblType = new JLabel("Trip Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblTypeDb = new JLabel("");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addContainerGap().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNameDb, GroupLayout.DEFAULT_SIZE, 180,
												Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTypeDb))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblStart, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(lblStartDb, GroupLayout.PREFERRED_SIZE, 81,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(2).addComponent(lblEndDb, GroupLayout.PREFERRED_SIZE, 91,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTransport, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(43)
										.addComponent(lblTransportType, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36).addComponent(lblTransportTypeDb, GroupLayout.DEFAULT_SIZE, 202,
												Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGap(43)
										.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblDepartureDb, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGap(43)
										.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblArrivalDb, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblApproval, GroupLayout.PREFERRED_SIZE, 108,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblApprovalDb,
												GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
								.addComponent(lblNameDb))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblType)
								.addComponent(lblTypeDb))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblStart)
								.addComponent(lblStartDb).addComponent(lblEnd).addComponent(lblEndDb))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblTransport).addGap(4)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblTransportType)
								.addComponent(lblTransportTypeDb))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblDeparture)
								.addComponent(lblDepartureDb))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblArrival)
								.addComponent(lblArrivalDb))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblApproval)
								.addComponent(lblApprovalDb))
						.addContainerGap(22, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * Set the text for the name label
	 * 
	 * @param tripName
	 */
	public void setNameLabel(String tripName) {
		lblNameDb.setText(tripName);
	}

	/**
	 * Set the text for the Start Date label
	 * 
	 * @param tripStart
	 */
	public void setStartLabel(String tripStart) {
		lblStartDb.setText(tripStart);
	}

	/**
	 * Set the text for the travel typeLabel
	 * 
	 * @param travelType
	 */
	public void setTripTypeLabel(String tripType) {
		lblTypeDb.setText(tripType);
	}

	/**
	 * Set the text for the end date label
	 * 
	 * @param endDate
	 */
	public void setEndLabel(String tripEnd) {
		lblEndDb.setText(tripEnd);
	}

	/**
	 * Set the text for the travel type label
	 * 
	 * @param travelType
	 */
	public void setTravelTypeLabel(String travelType) {
		lblTransportTypeDb.setText(travelType);
	}

	/**
	 * Set the text for the travel departure label
	 * 
	 * @param travelDeparture
	 */
	public void setTravelDepartureLabel(String travelDeparture) {
		lblDepartureDb.setText(travelDeparture);
	}

	/**
	 * Set the text for the travel arrival label
	 * 
	 * @param travelArrival
	 */
	public void setTravelArrivalLabel(String travelArrival) {
		lblArrivalDb.setText(travelArrival);
	}

	/**
	 * Set the text for the approval required label
	 * 
	 * @param approval
	 */
	public void setApprovalLabel(Boolean approval) {
		if (approval) {
			lblApprovalDb.setText("Yes");
		} else {
			lblApprovalDb.setText("No");
		}
	}
}
