package userInterface.panels;

import java.awt.Font;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import LabelFormatters.DateLabelFormatter;

/**
 * @author Ella Love
 *
 *         An input panel used for accommodation details when added to a panel.
 *         Handles the retreiving of data inputted into the input fields.
 */
@SuppressWarnings("serial")
public class AccommodationPanel extends JPanel {
	private JTextField txtLocation;
	private JDatePickerImpl txtArrival;
	private JDatePickerImpl txtDeparture;

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

		// Create the text box
		txtLocation = new JTextField();
		txtLocation.setToolTipText("Enter the accommodation location");
		txtLocation.setColumns(10);

		// Create the date entry fields
		// Set the date entry fields properties
		Properties p = DateLabelFormatter.setProperties();

		// Create the arrival date entry field
		UtilDateModel modelArrival = new UtilDateModel();
		JDatePanelImpl datePanelArrival = new JDatePanelImpl(modelArrival, p);
		txtArrival = new JDatePickerImpl(datePanelArrival, new DateLabelFormatter());
		txtArrival.setToolTipText("Select the accommodation arrival date");

		// Create the departure date entry field
		UtilDateModel modelDeparture = new UtilDateModel();
		JDatePanelImpl datePanelDeparture = new JDatePanelImpl(modelDeparture, p);
		txtDeparture = new JDatePickerImpl(datePanelDeparture, new DateLabelFormatter());
		txtDeparture.setToolTipText("Select the accommodation departure date");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblAccommodation)
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblArrival)
										.addComponent(lblLocation).addComponent(lblDeparture))
								.addGap(14)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtLocation, GroupLayout.DEFAULT_SIZE, 345,
												Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtDeparture, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtArrival, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														113, Short.MAX_VALUE))
												.addGap(144)))))
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
						.addContainerGap(191, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * gets the content of the accommodation text field
	 * 
	 * @return accommodation
	 */
	public String getAccommodation() {
		String accommodation = txtLocation.getText();
		return accommodation;
	}

	/**
	 * gets the content of the accommodation arrival text field
	 * 
	 * @return accommodationArrival
	 */
	public String getAccommodationArrival() {

		String accommodationArrival = txtArrival.getJFormattedTextField().getText();
		return accommodationArrival;
	}

	/**
	 * gets the content of the accommodation departure text field
	 * 
	 * @return accommodationDeparture
	 */
	public String getAccommodationDeparture() {
		String accommodationDeparture = txtDeparture.getJFormattedTextField().getText();
		return accommodationDeparture;
	}

}
