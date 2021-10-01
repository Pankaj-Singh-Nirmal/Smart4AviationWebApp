package pl.smart4aviation.service;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pl.smart4aviation.model.RequestedDetails;

/**
 * Collection of methods, making it possible to achieve the business logic 
 * of the application.
 * 
 * @author Pankaj Singh Nirmal
 */

public interface Smart4AviationService 
{
	/**
	 * Returns the Flight Id for the combination of Flight Number with date of flight and
	 * Flight Id for the combination of IATA Airport Code and date of operation of airport.
	 * 
	 * @param  requestedDetails
	 * 		   Used to store the information given by user on the web page
	 * 
	 * @throws  JsonParseException 
	 * 			Exception type for parsing problems, used when non-well-formed content
	 * 			(content that does not conform to JSON syntax as per specification)is 
	 * 			encountered
	 * 
	 * @throws  JsonMappingException
	 * 			Checked exception used to signal fatal problems with mapping of content, 
	 * 			distinct from low-level I/O problems or data encoding/decoding problems
	 * 			
	 * @throws  IOException
	 * 			Signals that an I/O exception of some sort has occurred
	 * 
	 * @return  returns the Flight Id for the combination of Flight Number with date of flight 
	 * 		    and Flight Id for the combination of IATA Airport Code and date of operation of 
	 * 		    airport
	 */
	String getFlightId(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * Returns the weight of the cargo for a given Flight Id in Kg.
	 * 
	 * @param  requestedDetails
	 * 		   Used to store the information given by user on the web page
	 * 
	 * @throws  JsonParseException 
	 * 			Exception type for parsing problems, used when non-well-formed content
	 * 			(content that does not conform to JSON syntax as per specification)is 
	 * 			encountered
	 * 
	 * @throws  JsonMappingException
	 * 			Checked exception used to signal fatal problems with mapping of content, 
	 * 			distinct from low-level I/O problems or data encoding/decoding problems
	 * 			
	 * @throws  IOException
	 * 			Signals that an I/O exception of some sort has occurred
	 * 
	 * @return  returns the weight of the cargo for a given Flight Id in Kg
	 */
	double getCargoWeight(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * Returns the weight of the baggage for a given Flight Id in Kg.
	 * 
	 * @param  requestedDetails
	 * 		   Used to store the information given by user on the web page
	 * 
	 * @throws  JsonParseException 
	 * 			Exception type for parsing problems, used when non-well-formed content
	 * 			(content that does not conform to JSON syntax as per specification)is 
	 * 			encountered
	 * 
	 * @throws  JsonMappingException
	 * 			Checked exception used to signal fatal problems with mapping of content, 
	 * 			distinct from low-level I/O problems or data encoding/decoding problems
	 * 			
	 * @throws  IOException
	 * 			Signals that an I/O exception of some sort has occurred
	 * 
	 * @return  returns the weight of the baggage for a given Flight Id in Kg
	 */
	double getBaggageWeight(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * Returns the total number of flights departing from the airport.
	 * 
	 * @return  returns the total number of flights departing from the airport
	 */
	int getTotalFlightsDeparting();
	
	/**
	 * Returns the total number of flights arriving from the airport.
	 * 
	 * @return  returns the total number of flights arriving from the airport
	 */
	int getTotalFlightsArriving();
	
	/**
	 * Returns the total number of the baggage pieces arriving and departing from the airport.
	 * 
	 * @throws  JsonParseException 
	 * 			Exception type for parsing problems, used when non-well-formed content
	 * 			(content that does not conform to JSON syntax as per specification)is 
	 * 			encountered
	 * 
	 * @throws  JsonMappingException
	 * 			Checked exception used to signal fatal problems with mapping of content, 
	 * 			distinct from low-level I/O problems or data encoding/decoding problems
	 * 			
	 * @throws  IOException
	 * 			Signals that an I/O exception of some sort has occurred
	 * 
	 * @return  returns the total number of the baggage pieces arriving and departing from 
	 * 		    the airport
	 */
	Map<String, Integer> getTotalBaggagePieces() throws JsonParseException, JsonMappingException, IOException;
	
	/**
	 * Clears the ArrayList of flights arriving and departing from the airport.
	 */
	void clearFlightIdList();
}
