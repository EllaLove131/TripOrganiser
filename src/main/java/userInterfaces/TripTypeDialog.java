package userInterfaces;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class TripTypeDialog extends JDialog {

	// Interface variables
	private final JPanel tripTypePanel = new JPanel();
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel buttonPanel;
	private JRadioButton rdbtnDayExternal;
	private JRadioButton rdbtnResidentialTeacher;
	private JRadioButton rdbtnResidentialExternal;
	private JLabel lblTripType;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnDayTeacher;
	private JPanel tripInputPanel;

	/**
	 * Constructor
	 */
	public TripTypeDialog() {

		initComponents();
		eventHandller();
	}

	/**
	 * Create the interface.
	 */
	public void initComponents() {

//		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//title bar
		setTitle("New Trip");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TripTypeDialog.class.getResource("/resources/add.png")));
		
		//Layout
		setBounds(100, 100, 431, 516);
		tripTypePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			//combo box label
			lblTripType = new JLabel("Trip Type:");
			lblTripType.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		{
			//button layout
			buttonPanel = new JPanel();
			{
				//continue button
				btnAdd = new JButton("");
				btnAdd.setIcon(new ImageIcon(TripTypeDialog.class.getResource("/resources/add.png")));
				btnAdd.setActionCommand("OK");
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				//cancel button
				btnCancel = new JButton("");
				btnCancel.setIcon(new ImageIcon(TripTypeDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
			}
		}
		//Create the four radio buttons and add them to a group together
		{
			rdbtnDayTeacher = new JRadioButton("Day - Teacher Organised");
			//Select this as default
			rdbtnDayTeacher.setSelected(true);
			buttonGroup.add(rdbtnDayTeacher);
		}
		{
			rdbtnDayExternal = new JRadioButton("Day - External Provider");
			buttonGroup.add(rdbtnDayExternal);
		}
		{
			rdbtnResidentialTeacher = new JRadioButton("Residential - Teacher Organised");
			buttonGroup.add(rdbtnResidentialTeacher);
		}
		{
			rdbtnResidentialExternal = new JRadioButton("Residential - External Provider");
			buttonGroup.add(rdbtnResidentialExternal);
		}
		
		//Apply a group layout
		GroupLayout gl_tripTypePanel = new GroupLayout(tripTypePanel);
		gl_tripTypePanel.setHorizontalGroup(
			gl_tripTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tripTypePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTripType)
					.addGap(28)
					.addGroup(gl_tripTypePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnResidentialExternal)
						.addComponent(rdbtnDayExternal)
						.addComponent(rdbtnDayTeacher)
						.addComponent(rdbtnResidentialTeacher))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		gl_tripTypePanel.setVerticalGroup(
			gl_tripTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tripTypePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tripTypePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTripType)
						.addComponent(rdbtnDayTeacher))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnDayExternal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnResidentialTeacher)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnResidentialExternal)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		tripTypePanel.setLayout(gl_tripTypePanel);
		
		//Create the trip input panel to hold the required input panels
		tripInputPanel = new JPanel();
		//Apply a group layout 
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
						.addComponent(tripTypePanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(tripInputPanel, 0, 0, Short.MAX_VALUE)))
					.addGap(7))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tripTypePanel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tripInputPanel, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		
		//Apply a box layout to the input panel, this will display the added panels in the required way
		tripInputPanel.setLayout(new BoxLayout(tripInputPanel, BoxLayout.Y_AXIS));
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap(326, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addGap(5)
					.addComponent(btnCancel)
					.addGap(5))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(btnCancel)))
		);
		buttonPanel.setLayout(gl_buttonPanel);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Handles events.
	 */
	public void eventHandller() {
		
		//Create and add the following panels to the input panel:
			//This acts as the defaults for the input panel and matches that of the day teacher organised trip
		TripPanel tripPanel = new TripPanel();
		tripInputPanel.add(tripPanel);
		
		TravelPanel travelPanel = new TravelPanel();
		tripInputPanel.add(travelPanel);
		
		AllFeesPanel feesPanel = new AllFeesPanel();
		tripInputPanel.add(feesPanel);
		
		VenuePanel venuePanel = new VenuePanel(); 
		tripInputPanel.add(venuePanel);
		
		//Make everything fit into the JDialog
		pack();
		
		// Cancel button clicked
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//The residential teacher organised radio button is selected
		rdbtnResidentialTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Make sure the panel is empty
				tripInputPanel.removeAll();
				
				//Create and add the following panels to the input panel:
				TripPanel tripPanel = new TripPanel();
				tripInputPanel.add(tripPanel);
				
				TravelPanel travelPanel = new TravelPanel();
				tripInputPanel.add(travelPanel);
				
				AllFeesPanel feesPanel = new AllFeesPanel();
				tripInputPanel.add(feesPanel);
				
				VenuePanel venuePanel = new VenuePanel(); 
				tripInputPanel.add(venuePanel);
				
				AccommodationPanel accommodationPanel = new AccommodationPanel();
				tripInputPanel.add(accommodationPanel);
				
				//Make everything fit into the JDialog
				pack();
			}
		});
		
		//The day teacher organised radio button is selected
		rdbtnDayTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Make sure the panel is empty
				tripInputPanel.removeAll();
			
				//Create and add the following panels to the input panel:
				TripPanel tripPanel = new TripPanel();
				tripInputPanel.add(tripPanel);
				
				TravelPanel travelPanel = new TravelPanel();
				tripInputPanel.add(travelPanel);
				
				AllFeesPanel feesPanel = new AllFeesPanel();
				tripInputPanel.add(feesPanel);
				
				VenuePanel venuePanel = new VenuePanel(); 
				tripInputPanel.add(venuePanel);
				
				//Make everything fit into the JDialog
				pack();
			}
		});
		
		//The residential externally organised radio button is selected
		rdbtnResidentialExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Make sure the panel is empty
				tripInputPanel.removeAll();
				
				//Create and add the following panels to the input panel:
				TripPanel tripPanel = new TripPanel();
				tripInputPanel.add(tripPanel);
				
				TravelPanel travelPanel = new TravelPanel();
				tripInputPanel.add(travelPanel);

				EntranceFeesPanel feePanel = new EntranceFeesPanel();
				tripInputPanel.add(feePanel);
				
				//Make everything fit into the JDialog
				pack();
			}
		});
		
		//The day externally organised radio button is selected
		rdbtnDayExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Make sure the panel is empty
				tripInputPanel.removeAll();
				
				//Create and add the following panels to the input panel:
				TripPanel tripPanel = new TripPanel();
				tripInputPanel.add(tripPanel);

				TravelPanel travelPanel = new TravelPanel();
				tripInputPanel.add(travelPanel);
				
				EntranceFeesPanel feePanel = new EntranceFeesPanel();
				tripInputPanel.add(feePanel);
				
				//Make everything fit into the JDialog
				pack();
			}
		});
	}
}
