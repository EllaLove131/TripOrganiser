/**
 * 
 */
package userInterfaces;

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
		txtEntranceFees.setColumns(10);

		txtSundryFees = new JTextField();
		txtSundryFees.setColumns(10);

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING).addGroup(
								groupLayout
										.createSequentialGroup().addGap(10).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblEntranceFees, GroupLayout.PREFERRED_SIZE, 82,
																GroupLayout.PREFERRED_SIZE)
														.addGap(6).addComponent(txtEntranceFees,
																GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblSundryFees, GroupLayout.PREFERRED_SIZE, 66,
																GroupLayout.PREFERRED_SIZE)
														.addGap(22).addComponent(txtSundryFees,
																GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblFees)).addContainerGap(145, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblFees)
						.addPreferredGap(ComponentPlacement.RELATED).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblEntranceFees))
								.addComponent(txtEntranceFees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblSundryFees))
								.addComponent(txtSundryFees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(223, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * gets the text from the entrance fee text field
	 * @return entranceFee
	 */
	public Double getEntranceFee() {
		Double entranceFee = Double.parseDouble(txtEntranceFees.getText());
		return entranceFee;
	}
	
	/**
	 * gets the text from the sundryFee field
	 * @return sundryFee
	 */
	public Double getSundryFee() { 
		double sundryFee = Double.parseDouble(txtSundryFees.getText()); 
		return sundryFee; 
	}
}
