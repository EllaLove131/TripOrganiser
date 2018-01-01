/**
 * 
 */
package userInterfaces;

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
public class AllFeesDisplayPanel extends JPanel {
	private JLabel lblEntranceDb;
	private JLabel lblSundryDb;

	/**
	 * Create the panel.
	 */
	public AllFeesDisplayPanel() {
		
		//Create the labels
		lblEntranceDb = new JLabel("");
		
		JLabel lblEntrance = new JLabel("Entrance:");
		lblEntrance.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblFees = new JLabel("Trip Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblSundry = new JLabel("Sundry:");
		lblSundry.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblSundryDb = new JLabel("");
		
		//Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFees, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSundry, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSundryDb, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEntrance, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblEntranceDb, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFees)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEntrance)
						.addComponent(lblEntranceDb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSundry)
						.addComponent(lblSundryDb))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Set the text for the entrance fee label
	 * @param entranceFee
	 */
	public void setEntranceFeeLabel(Double entranceFee) {
		String entrance = Double.toString(entranceFee);
		lblEntranceDb.setText("£ " + entrance);
	}
	/**
	 * Set the text for the sundry fee label
	 * @param sundryFee
	 */
	public void setSundryFeeLabel(Double sundryFee) {
		String sundry = Double.toString(sundryFee);
		lblSundryDb.setText("£ " + sundry);
	}
}
