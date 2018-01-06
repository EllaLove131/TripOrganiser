/**
 * 
 */
package userInterface.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class AllFeesPanel extends JPanel {
	private JTextField txtEntranceFees;
	private JTextField txtSundryFees;

	/**
	 * Constructor
	 */
	public AllFeesPanel() {

		initComponents();
	}

	/**
	 * Created the panel
	 */
	private void initComponents() {

		// Create the Labels
		JLabel lblEntranceFees = new JLabel("Entrance Fees:");
		lblEntranceFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblSundryFees = new JLabel("Sundry Fee:");
		lblSundryFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the text fields
		txtEntranceFees = new JTextField();
		txtEntranceFees.setToolTipText("Enter the trip entrance fee");
		txtEntranceFees.setColumns(10);

		txtSundryFees = new JTextField();
		txtSundryFees.setToolTipText("Enter the trip sundry fee");
		txtSundryFees.setColumns(10);
		
		JLabel lblPoundSundry = new JLabel("£");
		
		JLabel lblPoundEntrance = new JLabel("£");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFees)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSundryFees, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPoundSundry)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtSundryFees, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEntranceFees, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPoundEntrance)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
							.addGap(125))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFees)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEntranceFees)
						.addComponent(lblPoundEntrance)
						.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSundryFees)
						.addComponent(lblPoundSundry)
						.addComponent(txtSundryFees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	/**
	 * gets the text from the entrance fee text field
	 * @return entranceFee
	 */
	public Double getEntranceFee() throws NumberFormatException { 
		Double entranceFee = Double.valueOf(txtEntranceFees.getText());
		return entranceFee;
	}
	
	/**
	 * gets the text from the sundryFee field
	 * @return sundryFee
	 */
	public Double getSundryFee() throws NumberFormatException { 
		Double sundryFee = Double.valueOf(txtSundryFees.getText()); 
		return sundryFee; 
	}
}
