/**
 * 
 */
package userInterfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Models.Trip;
import Queries.TripQueries;

/**
 * @author Ella Love
 *
 */
public class AddTripEvent implements ActionListener{

	private AddTripDialog addTripDialog;
	
	public AddTripEvent(AddTripDialog addTripDialog)
	{
		this.addTripDialog = addTripDialog;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// Add the trip to the db...
		// Get the values from each text box
		String tripName = addTripDialog.tripPanel.getTripName();
		String startDate = tripPanel.getStartDate();
		String endDate = tripPanel.getEndDate();
		String travelType = travelPanel.getTravelType();
		String travelDeparture = travelPanel.getTravelDeparture();
		String travelArrival = travelPanel.getTravelArival();

		// Get the values depending on the panels being show, i.e. the
		// trip type
		if (tripType == "ResidentialTeacher") {
			Double entranceFee = allFeesPanel.getEntranceFee();
			Double sundryFee = allFeesPanel.getSundryFee();
			String venue = venuePanel.getVenue();
			String accommodation = accommodationPanel.getAccommodation();
			String accommodationArrival = accommodationPanel.getAccommodationArrival();
			String accommodationDeparture = accommodationPanel.getAccommodationDeparture();

		} else if (tripType == "DayTeacher") {
			Double entranceFee = allFeesPanel.getEntranceFee();
			Double sundryFee = allFeesPanel.getSundryFee();
			String venue = venuePanel.getVenue();

		} else if (tripType == "ResidentialExternal" || tripType == "DayExternal") {
			Double entranceFee = entranceFeePanel.getEntranceFee();
		}

		// Error message to be populated if there is a verification
		// issue
		String errorMessage = "";

		// Create a new group
		Trip newTrip = new Trip();

		// Verify the data
		if (!newTrip.setTripName(tripName)) {
			errorMessage = "Name field is empty";
		}

		if (!newTrip.setStartDate(startDate)) {
			errorMessage = "Start date field is empty";
		}

		if (!newTrip.setEndDate(endDate)) {
			errorMessage = "End date field is empty";
		}

		if (!newTrip.setTransportType(transportType)) {

		}

		// If the data is verified
		if (errorMessage.isEmpty()) {
			// Add the trip to the db
			new TripQueries().addTrip(newTrip);
			// Update the display

			// Show a verification dialog
			JOptionPane.showMessageDialog(null, "Trip added succesfully.");

			// close the view
			dispose();
		}
	}

}
