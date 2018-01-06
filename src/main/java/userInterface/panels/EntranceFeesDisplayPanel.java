package userInterface.panels;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Ella Love
 *
 *         Creates the trip fee display panel that displays trip fee information
 *         when added to a panel. Includes the entrance fee only. Allows for the
 *         setting of values within the text labels
 */
@SuppressWarnings("serial")
public class EntranceFeesDisplayPanel extends JPanel {
	private JLabel lblEntranceFeeDb;

	/**
	 * Create the panel.
	 */
	public EntranceFeesDisplayPanel() {

		// Create the labels
		JLabel lblFees = new JLabel("Trip Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblEntranceFee = new JLabel("Entrance:");
		lblEntranceFee.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblEntranceFeeDb = new JLabel("");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFees, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(19)
										.addComponent(lblEntranceFee, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(lblEntranceFeeDb, GroupLayout.PREFERRED_SIZE, 235,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblFees)
						.addGap(6).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEntranceFee).addComponent(lblEntranceFeeDb))
						.addContainerGap(255, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * Set the text for the entrance fee label
	 * 
	 * @param entrance
	 *            fee
	 */
	public void setEntranceFeeLabel(Double entranceFee) {
		DecimalFormat df = new DecimalFormat(".##");
		df.format(entranceFee);
		String entrance = Double.toString(entranceFee);
		lblEntranceFeeDb.setText("£ " + entrance);
	}
}
