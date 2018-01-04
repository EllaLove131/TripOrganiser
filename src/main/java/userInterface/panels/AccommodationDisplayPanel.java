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
 */
@SuppressWarnings("serial")
public class AccommodationDisplayPanel extends JPanel {
	private JLabel lblArrivalDb;
	private JLabel lblDepartureDb;
	private JLabel lblAccommodationDb;

	/**
	 * Create the panel.
	 */
	public AccommodationDisplayPanel() {
		
		//Create the labels
		JLabel lblAccommodation = new JLabel("Accommodation:");
		lblAccommodation.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblAccommodationDb = new JLabel("");
		
		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDepartureDb = new JLabel("");
		
		lblArrivalDb = new JLabel("");
		
		//Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDepartureDb, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblAccommodation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(43)
									.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAccommodationDb, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(lblArrivalDb, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccommodation)
						.addComponent(lblAccommodationDb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArrival)
						.addComponent(lblArrivalDb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeparture)
						.addComponent(lblDepartureDb))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	/**
	 * Set the text for the accommodation label
	 * @param accommodation
	 */
	public void setAccommodationLabel(String accommodation) {
		lblAccommodationDb.setText(accommodation);
	}
	/**
	 * Set the text for the accommodation arrival label
	 * @param accommodationArrival
	 */
	public void setAccommodationArrivalLabel(String accommodationArrival) {
		lblArrivalDb.setText(accommodationArrival);
	}
	/**
	 * Set the text for the accommodation departure label
	 * @param accommodationDeparture
	 */
	public void setAccommodationDepartureLabel(String accommodationDeparture) {
		lblDepartureDb.setText(accommodationDeparture);
	}
}
