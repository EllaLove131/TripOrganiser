package Models;

/**
 * 
 * @author Ella Love
 *
 *         A trip container class for storing student information.
 */
public class Trip {

	private String tripType;
	private int tripId;
	private String tripName;
	private String startDate;
	private String endDate;
	private Double entranceFee;
	private String transportType;
	private String transportDeparture;
	private String transportArrival;
	private boolean approvalRequired;

	private Double sundryFee;
	private String venue;
	private String accommodation;
	private String accommodationArrival;
	private String accommodationDeparture;

	// Getters and setters
	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public boolean setTripName(String tripName) {
		if (tripName.isEmpty() || tripName.length() > 40) {
			return false;
		}
		this.tripName = tripName;
		return true;
	}

	public String getStartDate() {
		return startDate;
	}

	public boolean setStartDate(String startDate) {
		if (startDate.isEmpty()) {
			return false;
		}
		this.startDate = startDate;
		return true;
	}

	public String getEndDate() {
		return endDate;
	}

	public boolean setEndDate(String endDate) {
		if (endDate.isEmpty()) {
			return false;
		}
		this.endDate = endDate;
		return true;
	}

	public Double getEntranceFee() {
		return entranceFee;
	}

	public boolean setEntranceFee(Double entranceFee) {
		if (entranceFee == null || entranceFee > 999999.99) {
			return false;
		}

		this.entranceFee = entranceFee;
		return true;
	}

	public String getTransportType() {
		return transportType;
	}

	public boolean setTransportType(String transportType) {
		if (transportType.isEmpty()) {
			return false;
		}
		this.transportType = transportType;
		return true;
	}

	public String getTransportDeparture() {
		return transportDeparture;
	}

	public boolean setTransportDeparture(String transportDeparture) {
		if (transportDeparture.isEmpty()) {
			return false;
		}
		this.transportDeparture = transportDeparture;
		return true;
	}

	public String getTransportArrival() {
		return transportArrival;
	}

	public boolean setTransportArrival(String transportArrival) {
		if (transportArrival.isEmpty()) {
			return false;
		}
		this.transportArrival = transportArrival;
		return true;
	}

	public boolean isApprovalRequired() {
		return approvalRequired;
	}

	public void setApprovalRequired(boolean approvalRequired) {
		this.approvalRequired = approvalRequired;
	}

	public Double getSundryFee() {
		return sundryFee;
	}

	public boolean setSundryFee(Double sundryFee) {
		if (sundryFee == null || sundryFee > 999999.99) {
			return false;
		}
		this.sundryFee = sundryFee;
		return true;
	}

	public String getVenue() {
		return venue;
	}

	public boolean setVenue(String venue) {
		if (venue.isEmpty() || venue.length() > 40) {
			return false;
		}
		this.venue = venue;
		return true;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public boolean setAccommodation(String accommodation) {
		if (accommodation.isEmpty() || accommodation.length() > 40) {
			return false;
		}
		this.accommodation = accommodation;
		return true;
	}

	public String getAccommodationArrival() {
		return accommodationArrival;
	}

	public boolean setAccommodationArrival(String accommodationArrival) {
		if (accommodationArrival.isEmpty()) {
			return false;
		}
		this.accommodationArrival = accommodationArrival;
		return true;
	}

	public String getAccommodationDeparture() {
		return accommodationDeparture;
	}

	public boolean setAccommodationDeparture(String accommodationDeparture) {
		if (accommodationDeparture.isEmpty()) {
			return false;
		}
		this.accommodationDeparture = accommodationDeparture;
		return true;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
}
