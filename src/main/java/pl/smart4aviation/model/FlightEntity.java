package pl.smart4aviation.model;

/**
 * A model class which is used to store the information of the flight such as flightId, 
 * flightNumber, departureAirportIATACode, arrivalAirportIATACode and departureDate from 
 * JSON file.
 * 
 * @author Pankaj Singh Nirmal
 */

public class FlightEntity 
{
	private Long flightId;
	private Long flightNumber;
	private String departureAirportIATACode;
	private String arrivalAirportIATACode;
	private String departureDate;
	
	/**
	 * @return  returns the Flight Id mapped to the JSON file
	 */
	public Long getFlightId() {
		return flightId;
	}
	/**
	 * @param  flightId 
	 * 		   Flight Id mapped to the JSON file		   
	 */
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	/**
	 * @return  returns the Flight Number mapped to the JSON file
	 */
	public Long getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param  flightNumber 
	 * 		   Flight Number mapped to the JSON file		   
	 */
	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return  returns the departure IATA Airport Code mapped to the JSON file
	 */
	public String getDepartureAirportIATACode() {
		return departureAirportIATACode;
	}
	/**
	 * @param  departureAirportIATACode 
	 * 		   Departure IATA Airport Code mapped to the JSON file		   
	 */
	public void setDepartureAirportIATACode(String departureAirportIATACode) {
		this.departureAirportIATACode = departureAirportIATACode;
	}
	/**
	 * @return  returns the arrival IATA Airport Code mapped to the JSON file
	 */
	public String getArrivalAirportIATACode() {
		return arrivalAirportIATACode;
	}
	/**
	 * @param  arrivalAirportIATACode 
	 * 		   Arrival IATA Airport Code mapped to the JSON file		   
	 */
	public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
		this.arrivalAirportIATACode = arrivalAirportIATACode;
	}
	/**
	 * @return  returns the departure date of the flight mapped to the JSON file
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param  departureDate 
	 * 		   Departure date of the flight mapped to the JSON file		   
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureAirportIATACode="
				+ departureAirportIATACode + ", arrivalAirportIATACode=" + arrivalAirportIATACode + ", departureDate="
				+ departureDate + "]";
	}
}
