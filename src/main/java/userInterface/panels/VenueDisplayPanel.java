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
 *         Creates the trip venue display panel that displays trip
 *         accommodation information when added to a panel. Allows for the
 *         setting of values within the text labels
 */
@SuppressWarnings("serial")
public class VenueDisplayPanel extends JPanel {
	private JLabel lblVenueDb;

	/**
	 * Create the panel.
	 */
	public VenueDisplayPanel() {

		// Create the labels
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblVenueDb = new JLabel("");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblVenue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblVenueDb, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVenue).addComponent(lblVenueDb))
						.addContainerGap(275, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * Set the text of the venue label
	 * 
	 * @param venue
	 */
	public void setVenueLabel(String venue) {
		lblVenueDb.setText(venue);
	}
}
