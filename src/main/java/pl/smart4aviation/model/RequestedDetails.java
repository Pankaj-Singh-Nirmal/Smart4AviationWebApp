package pl.smart4aviation.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * A model class which is used to store the information given by user on the web page.
 * 
 * @author Pankaj Singh Nirmal
 */

public class RequestedDetails
{
	@Pattern(regexp="^[-+]?\\d+$", message="* Flight number must be numeric and non-empty !")
	private String requestedFlightNumber;
	
	@NotEmpty(message="* Date can not be empty !")
	@Pattern(regexp="^$|^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message="* Invalid date format !")
	private String requestedFlightDate;
	
	@Pattern(regexp="^[a-zA-Z]{3}$", message="* Invalid format for IATA Airport Code !")
	private String requestedAirportCode;
	
	@NotEmpty(message="* Date can not be empty !")
	@Pattern(regexp="^$|^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message="* Invalid date format !")
	private String requestedAirportDate;
	
	/**
	 * @return  returns the Flight Number entered by the user on web page
	 */
	public String getRequestedFlightNumber() {
		return requestedFlightNumber;
	}
	/**
	 * @param  requestedFlightNumber 
	 * 		   Flight Number entered by the user on web page		   
	 */
	public void setRequestedFlightNumber(String requestedFlightNumber) {
		this.requestedFlightNumber = requestedFlightNumber;
	}
	/**
	 * @return  returns the Date of the Flight entered by the user on web page
	 */
	public String getRequestedFlightDate() {
		return requestedFlightDate;
	}
	/**
	 * @param  requestedFlightDate 
	 * 		   Date of the Flight entered by the user on web page		   
	 */
	public void setRequestedFlightDate(String requestedFlightDate) {
		this.requestedFlightDate = requestedFlightDate;
	}
	/**
	 * @return  returns the IATA Airport Code entered by the user on web page
	 */
	public String getRequestedAirportCode() {
		return requestedAirportCode;
	}
	/**
	 * @param  requestedAirportCode 
	 * 		   IATA Airport Code entered by the user on web page		   
	 */
	public void setRequestedAirportCode(String requestedAirportCode) {
		this.requestedAirportCode = requestedAirportCode;
	}
	/**
	 * @return  returns the date of operation of the airport entered by the user on web page
	 */
	public String getRequestedAirportDate() {
		return requestedAirportDate;
	}
	/**
	 * @param  requestedAirportDate 
	 * 		   Date of operation of the airport entered by the user on web page		   
	 */
	public void setRequestedAirportDate(String requestedAirportDate) {
		this.requestedAirportDate = requestedAirportDate;
	}
	
	@Override
	public String toString() {
		return "RequestedDetails [requestedFlightNumber=" + requestedFlightNumber + ", requestedFlightDate="
				+ requestedFlightDate + ", requestedAirportCode=" + requestedAirportCode + ", requestedAirportDate="
				+ requestedAirportDate + "]";
	}
}
