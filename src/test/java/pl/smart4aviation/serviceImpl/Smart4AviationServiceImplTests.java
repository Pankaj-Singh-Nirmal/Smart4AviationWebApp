package pl.smart4aviation.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pl.smart4aviation.model.RequestedDetails;
import pl.smart4aviation.service.Smart4AviationService;

@SpringBootTest
@DisplayName("Tests for class Smart4AviationServiceImpl")
class Smart4AviationServiceImplTests 
{
	@Autowired
	private Smart4AviationService smart4AviationService;
	
	private RequestedDetails requestedDetails = new RequestedDetails();
	
	@Nested
	class MethodsRequiringFlightIdTests
	{
		@BeforeEach
		void setUp() throws JsonParseException, JsonMappingException, IOException 
		{
			requestedDetails.setRequestedFlightNumber("5837");
			requestedDetails.setRequestedFlightDate("2020-02-25");
			smart4AviationService.getFlightId(requestedDetails);
		}
		
		@Test
		@DisplayName("Should Get Flight Id")
		void shouldGetFlightId() throws JsonParseException, JsonMappingException, IOException 
		{	
			/** given **/
			// FlightId is 1 as obtained from setUp()
			
			/** when **/
			String actual = smart4AviationService.getFlightId(requestedDetails);
			
			/** then **/
			String expected = "1";
			assertThat(actual).isEqualTo(expected);
		}
		
		@Test
		@DisplayName("Should Get Cargo Weight")
		void shouldGetCargoWeight() throws JsonParseException, JsonMappingException, IOException 
		{	
			/** given **/
			// FlightId is 1 as obtained from setUp()
			
			/** when **/
			double actual = smart4AviationService.getCargoWeight(requestedDetails);
			
			/** then **/
			double expected = 2890.929192;
			assertThat(actual).isEqualTo(expected);
		}
	
		@Test
		@DisplayName("Should Get Baggage Weight")
		void shouldGetBaggageWeight() throws JsonParseException, JsonMappingException, IOException 
		{	
			/** given **/
			// FlightId is 1 as obtained from setUp()
			
			/** when **/
			double actual = smart4AviationService.getBaggageWeight(requestedDetails);
			
			/** then **/
			double expected = 1314.540104;
			assertThat(actual).isEqualTo(expected);
		}
	}
		
	@Test
	@DisplayName("Should Get Total Flights Departing")
	void shouldGetTotalFlightsDeparting() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		// clean up for previously created Lists 
		// for arrival and departure FlightId
		smart4AviationService.clearFlightIdList(); 
		
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("YYT");
		requestedDetails.setRequestedAirportDate("2019-10-08");
		smart4AviationService.getFlightId(requestedDetails);
		// FlightId obtained here is 2
		
		/** when **/
		int actual = smart4AviationService.getTotalFlightsDeparting();
		
		/** then **/
		int expected = 1;
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Get Zero As Total Flights Departing")
	void shouldGetZeroAsTotalFlightsDeparting() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("HHH"); // Doesn't exist
		requestedDetails.setRequestedAirportDate("2019-10-08");
		smart4AviationService.getFlightId(requestedDetails);
		// No FlightId is obtained here as IATA Airport Code doesn't exist
		
		/** when **/
		int actual = smart4AviationService.getTotalFlightsDeparting();
		
		/** then **/
		int expected = 0;
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Get Total Flights Arriving")
	void shouldGetTotalFlightsArriving() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("MIT");
		requestedDetails.setRequestedAirportDate("2016-01-02");
		smart4AviationService.getFlightId(requestedDetails);
		// FlightId obtained here is 3
		
		/** when **/
		int actual = smart4AviationService.getTotalFlightsArriving();
		
		/** then **/
		int expected = 1;
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Get Zero As Total Flights Arriving")
	void shouldGetZeroAsTotalFlightsArriving() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("YYZ"); 
		requestedDetails.setRequestedAirportDate("2019-10-08");
		smart4AviationService.getFlightId(requestedDetails);
		// No FlightId is obtained here as no flights are arriving on 2019-10-08 at YYZ
		
		/** when **/
		int actual = smart4AviationService.getTotalFlightsArriving();
		
		/** then **/
		int expected = 0;
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Get Total Baggage Pieces")
	void shouldGetTotalBaggagePieces() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		// clean up for previously created Lists 
		// for arrival and departure FlightId
		smart4AviationService.clearFlightIdList();
		
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("LAX");
		requestedDetails.setRequestedAirportDate("2021-08-23");
		smart4AviationService.getFlightId(requestedDetails);
		// FlightId obtained here is 4
		
		/** when **/
		Map<String, Integer> actual = smart4AviationService.getTotalBaggagePieces();
		
		/** then **/
		Map<String, Integer> expected = Map.of("totalBaggagePiecesArriving", 0, "totalBaggagePiecesDeparting", 3123);
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Clear FlightId List")
	void shouldClearFlightIdList() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("MIT");
		requestedDetails.setRequestedAirportDate("2016-01-02");
		smart4AviationService.getFlightId(requestedDetails);
		assertThat(smart4AviationService.getTotalFlightsArriving()).isEqualTo(1);
		
		requestedDetails.setRequestedFlightNumber("5837");
		requestedDetails.setRequestedAirportCode("YYT");
		requestedDetails.setRequestedAirportDate("2019-10-08");
		smart4AviationService.getFlightId(requestedDetails);
		assertThat(smart4AviationService.getTotalFlightsDeparting()).isEqualTo(1);
		
		/** when **/
		smart4AviationService.clearFlightIdList();
		
		/** then **/
		int expectedDeparting = 0;
		int actualDeparting = 0;
		int expectedArriving = 0;
		int actualArriving = 0;
		assertThat(actualDeparting).isEqualTo(expectedDeparting);
		assertThat(actualArriving).isEqualTo(expectedArriving);
	}
	
}
