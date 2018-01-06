/**
 * 
 */
package userInterface.panels;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Ella Love
 *
 *         An input panel used for transport details when added to a panel.
 *         Handles the retreiving of data inputted into the input fields.
 */
@SuppressWarnings("serial")
public class TravelPanel extends JPanel {
	private JSpinner txtDeparture;
	private JSpinner txtArrival;
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

		// Create the labels
		JLabel lblTravel = new JLabel("Travel");
		lblTravel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblDeparture = new JLabel("Departure Time:");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblArrival = new JLabel("Arrival Time:");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the combo box and fill it's options
		cboType = new JComboBox<Object>();
		cboType.setToolTipText("Select the transport type");
		cboType.setModel(new DefaultComboBoxModel<Object>(new String[] { "Bus", "Walk", "Car", "Plane", "Other" }));

		// Create the time entry spinner fields
		txtDeparture = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditorDeparture = new JSpinner.DateEditor(txtDeparture, "HH:mm");
		txtDeparture.setEditor(timeEditorDeparture);
		txtDeparture.setValue(new Date());

		txtArrival = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditorArrival = new JSpinner.DateEditor(txtArrival, "HH:mm");
		txtArrival.setEditor(timeEditorArrival);
		txtArrival.setValue(new Date());

		// Apply group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(
								Alignment.LEADING)
								.addComponent(lblTravel, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE, 92,
																GroupLayout.PREFERRED_SIZE)
														.addGap(4).addComponent(txtDeparture,
																GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 72,
																GroupLayout.PREFERRED_SIZE)
														.addGap(24).addComponent(txtArrival, GroupLayout.PREFERRED_SIZE,
																104, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 31,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(cboType, 0, 264, Short.MAX_VALUE)))))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblTravel)
								.addGap(9).addComponent(lblType))
						.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(cboType,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblDeparture))
						.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblArrival))
						.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(12, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * gets the combo box selection
	 * 
	 * @return travelType
	 */
	public String getTravelType() {
		String travelType = (String) cboType.getSelectedItem();
		return travelType;
	}

	/**
	 * gets the text from the departure text box
	 * 
	 * @return departure
	 */
	public String getTravelDeparture() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) (txtDeparture.getValue()));
		String departure = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE));
		return departure;
	}

	/**
	 * gets the text from the arrival text box
	 * 
	 * @return arrival
	 */
	public String getTravelArrival() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) (txtArrival.getValue()));
		String arrival = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
		return arrival;
	}
}
