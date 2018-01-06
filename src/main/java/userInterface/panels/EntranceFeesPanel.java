package userInterface.panels;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Ella Love
 *
 *         An input panel used for fee details when added to a panel. Includes
 *         entrance fees only. Handles the retreiving of data inputted into the
 *         input fields.
 */
@SuppressWarnings("serial")
public class EntranceFeesPanel extends JPanel {
	private JTextField txtEntranceFees;

	/**
	 * Create the panel.
	 */
	public EntranceFeesPanel() {

		initComponents();
	}

	private void initComponents() {

		// Create the labels
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblEntranceFees = new JLabel("Entrance Fees:");
		lblEntranceFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the text field
		txtEntranceFees = new JTextField();
		txtEntranceFees.setToolTipText("Enter the trip entrance fee");
		txtEntranceFees.setColumns(10);

		JLabel lblPound = new JLabel("£");

		// Apply the group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFees, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addComponent(lblEntranceFees, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblPound).addGap(4)
										.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(246, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblFees).addGap(9)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEntranceFees)
								.addComponent(lblPound).addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * Gets the entrance fee from the text box
	 * 
	 * @return entranceFee
	 */
	public Double getEntranceFee() throws NumberFormatException {

		Double entranceFee = Double.valueOf(txtEntranceFees.getText());
		return entranceFee;
	}
}
