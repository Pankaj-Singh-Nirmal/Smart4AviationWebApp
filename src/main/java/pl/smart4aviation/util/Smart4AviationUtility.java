package pl.smart4aviation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.smart4aviation.model.CargoEntity;
import pl.smart4aviation.model.FlightEntity;

/**
 * Collection of methods, helping the Service class to achieve the business logic 
 * of the application.
 * 
 * @author Pankaj Singh Nirmal
 */

public final class Smart4AviationUtility 
{
	// fetch JSON data from file and convert to POJO
	static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Fetch the JSON data of Flight Entity from the file and convert into POJO.
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
	 * 
	 * @return returns the list of Flight Entity data converted from JSON data
	 */
	public static List<FlightEntity> getFlightEntity() throws JsonParseException, JsonMappingException, IOException
	{
		TypeReference<List<FlightEntity>> typeReference = new TypeReference<List<FlightEntity>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/static/json/flight_entity.json");
		List<FlightEntity> flightEntity = mapper.readValue(inputStream,typeReference);
		
		return flightEntity;
	}
	
	/**
	 * Fetch the JSON data of Cargo Entity from the file and convert into POJO.
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
	 * @return returns the list of Cargo Entity data converted from JSON data
	 */
	public static List<CargoEntity> getCargoEntity() throws JsonParseException, JsonMappingException, IOException
	{
		TypeReference<List<CargoEntity>> typeReference = new TypeReference<List<CargoEntity>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/static/json/cargo_entity.json");
		List<CargoEntity> cargoEntity = mapper.readValue(inputStream,typeReference);
		
		return cargoEntity;
	}
}
