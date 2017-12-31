/**
 * 
 */
package userInterfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ella Love
 *
 */
public class AddTripInputPanelsEvent implements ActionListener {

	private String tripType;
	private TripPanel tripInputPanel;
	private AddTripDialog addTripDialog;
	
	private TripPanel tripPanel;
	private TravelPanel travelPanel;
	private AllFeesPanel allFeesPanel;
	private VenuePanel venuePanel;
	private EntranceFeesPanel entranceFeePanel;
	private AccommodationPanel accommodationPanel;
	
	public AddTripInputPanelsEvent(String tripType, TripPanel tripInputPanel, AddTripDialog addTripDialog)
	{
		this.tripType = tripType;
		this.tripInputPanel = tripInputPanel;
		this.addTripDialog = addTripDialog;
		
		// Create the following panels:
		tripPanel = new TripPanel();
		travelPanel = new TravelPanel();
		allFeesPanel = new AllFeesPanel();
		venuePanel = new VenuePanel();
		entranceFeePanel = new EntranceFeesPanel();
		accommodationPanel = new AccommodationPanel();

		// Add the panels for the defualt - day, teacher organised trip
		tripInputPanel.add(tripPanel);
		tripInputPanel.add(travelPanel);
		tripInputPanel.add(allFeesPanel);
		tripInputPanel.add(venuePanel);

		// Make everything fit into the JDialog
		addTripDialog.pack();
	}
	
	public void actionPerformed(ActionEvent e) {

		// Set the trip type
		if (tripType == "ResidentialTeacher")
		{
			// Make sure the panel is empty
			tripInputPanel.removeAll();
	
			// Add the following panels to the input panel:
	
			tripInputPanel.add(tripPanel);
			tripInputPanel.add(travelPanel);
			tripInputPanel.add(allFeesPanel);
			tripInputPanel.add(venuePanel);
			tripInputPanel.add(accommodationPanel);
	
			// Make everything fit into the JDialog
			addTripDialog.pack();	
		}
		else if (tripType.equals("DayTeacher"))
		{
			// Make sure the panel is empty
			tripInputPanel.removeAll();
	
			// Add the following panels to the input panel:
			tripInputPanel.add(tripPanel);
			tripInputPanel.add(travelPanel);
			tripInputPanel.add(allFeesPanel);
			tripInputPanel.add(venuePanel);
	
			// Make everything fit into the JDialog
			addTripDialog.pack();
		}
		else if (tripType.equals("ResidentialExternal"))
		{
			// Make sure the panel is empty
			tripInputPanel.removeAll();

			// Add the following panels to the input panel:
			tripInputPanel.add(tripPanel);
			tripInputPanel.add(travelPanel);
			tripInputPanel.add(entranceFeePanel);

			// Make everything fit into the JDialog
			addTripDialog.pack();
		}
		else if (tripType.equals("DayExternal"))
		{
			// Make sure the panel is empty
			tripInputPanel.removeAll();

			// Add the following panels to the input panel:
			tripInputPanel.add(tripPanel);
			tripInputPanel.add(travelPanel);
			tripInputPanel.add(entranceFeePanel);

			// Make everything fit into the JDialog
			addTripDialog.pack();
		} 
	}
}
