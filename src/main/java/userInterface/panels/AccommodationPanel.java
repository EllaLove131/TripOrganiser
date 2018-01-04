/**
 * 
 */
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
 */
@SuppressWarnings("serial")
public class AccommodationPanel extends JPanel {
	private JTextField txtLocation;
	private JTextField txtArrival;
	private JTextField txtDeparture;

	/**
	 * Constructor
	 */
	public AccommodationPanel() {

		initComponents();
	}

	/**
	 * Create the panel.
	 */
	private void initComponents() {

		// Create the labels
		JLabel lblAccommodation = new JLabel("Accommodation");
		lblAccommodation.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblArrival = new JLabel("Arrival:");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDeparture = new JLabel("Departure:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the text boxes
		txtLocation = new JTextField();
		txtLocation.setColumns(10);

		txtArrival = new JTextField();
		txtArrival.setColumns(10);

		txtDeparture = new JTextField();
		txtDeparture.setColumns(10);

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
								.addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAccommodation).addGroup(
												groupLayout
														.createSequentialGroup().addGap(10).addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING)
																.addComponent(lblArrival).addComponent(lblLocation)
																.addComponent(lblDeparture))
														.addGap(14)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(txtLocation, GroupLayout.DEFAULT_SIZE,
																		224, Short.MAX_VALUE))))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblAccommodation)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLocation))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArrival))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeparture))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
	
	/**
	 * gets the content of the accommodation text field
	 * @return accommodation 
	 */
	public String getAccommodation() { 
		String accommodation = txtLocation.getText();
		return accommodation;
	}
	
	/**
	 * gets the content of the accommodation arrival text field
	 * @return accommodationArrival
	 */
	public String getAccommodationArrival() { 
		String accommodationArrival = txtArrival.getText();
		return accommodationArrival;
	}
	
	/**
	 * gets the content of the accommodation departure text field
	 * @return accommodationDeparture
	 */
	public String getAccommodationDeparture() { 
		String accommodationDeparture = txtDeparture.getText();
		return accommodationDeparture;
	}
	
}
