/**
 * 
 */
package userInterfaces;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * @author Ella Love
 *
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
		
		//Create the labels
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEntranceFees = new JLabel("Entrance Fees:");
		lblEntranceFees.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//Create the text field
		txtEntranceFees = new JTextField();
		txtEntranceFees.setColumns(10);
		
		//Apply the group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFees, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEntranceFees, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFees)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEntranceFees))
						.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}
	
	/**
	 * Gets the entrance fee from the text box
	 * @return entranceFee
	 */
	public Double getEntranceFee() throws NumberFormatException { 
		Double entranceFee = Double.valueOf(txtEntranceFees.getText());
		return entranceFee;
	}
}
