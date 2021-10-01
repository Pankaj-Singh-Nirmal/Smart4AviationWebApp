package pl.smart4aviation.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@DisplayName("Tests for class Smart4AviationUtility")
class Smart4AviationUtilityTests 
{

	@Test
	@DisplayName("Should Get Flight Entity")
	void shouldGetFlightEntity() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		int expected = 5;
		
		/** when **/
		// Taking only first index of the FlightEntity
		int actual = Smart4AviationUtility.getFlightEntity().size();
		
		/** then **/
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	@DisplayName("Should Get Cargo Entity")
	void shouldGetCargoEntity() throws JsonParseException, JsonMappingException, IOException 
	{	
		/** given **/
		long expectedFlightId = 0;
		int expectedBaggageArrayLength = 6;
		int expectedCargoArrayLength = 4;
		
		/** when **/
		// Taking only first index of the CargoEntity
		long actualFlightId = Smart4AviationUtility.getCargoEntity().get(0).getFlightId();
		int actualBaggageArrayLength = Smart4AviationUtility.getCargoEntity().get(0).getBaggage().length;
		int actualCargoArrayLength = Smart4AviationUtility.getCargoEntity().get(0).getCargo().length;
		
		/** then **/
		assertThat(actualFlightId).isEqualTo(expectedFlightId);
		assertThat(actualBaggageArrayLength).isEqualTo(expectedBaggageArrayLength);
		assertThat(actualCargoArrayLength).isEqualTo(expectedCargoArrayLength);
	}

}
