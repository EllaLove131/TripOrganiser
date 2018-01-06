/**
 * 
 */
package userInterface.panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class TravelPanel extends JPanel {
	private JTextField txtDeparture;
	private JTextField txtArrival;
	private JComboBox<Object> cboType;

	/**
	 * Constructor
	 */
	public TravelPanel() {
		 
		initComponents();
	}

	/**
	 * Create the panel
	 */
	private void initComponents() {

		//Create the labels
		JLabel lblTravel = new JLabel("Travel");
		lblTravel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDeparture = new JLabel("Departure Time:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblArrival = new JLabel("Arrival Time:");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//Create the combo box and fill it's options
		cboType = new JComboBox<Object>();
		cboType.setToolTipText("Select the transport type");
		cboType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Bus", "Walk", "Car", "Plane", "Other"}));
		
		//Create the text fields
		txtDeparture = new JTextField();
		txtDeparture.setToolTipText("Enter the time of departure");
		txtDeparture.setColumns(10);
		
		txtArrival = new JTextField();
		txtArrival.setToolTipText("Enter the time of arrival");
		txtArrival.setColumns(10);
		
		//Apply  group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTravel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cboType, 0, 264, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTravel)
							.addGap(9)
							.addComponent(lblType))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(cboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDeparture))
						.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblArrival))
						.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	/**
	 * gets the combo box selection
	 * @return travelType
	 */
	public String getTravelType() { 
		String travelType = (String) cboType.getSelectedItem();
		return travelType;
	}
	/**
	 * gets the text from the departure text box
	 * @return departure
	 */
	public String getTravelDeparture() { 
		String departure = txtDeparture.getText();
		return departure;
	}
	
	/**
	 * gets the text from the arrival text box
	 * @return arrival
	 */
	public String getTravelArival() { 
		String arrival = txtArrival.getText();
		return arrival;
	}
}