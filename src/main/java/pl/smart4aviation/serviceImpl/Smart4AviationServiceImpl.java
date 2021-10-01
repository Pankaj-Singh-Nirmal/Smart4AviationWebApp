package pl.smart4aviation.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pl.smart4aviation.model.CargoEntity;
import pl.smart4aviation.model.FlightEntity;
import pl.smart4aviation.model.RequestedDetails;
import pl.smart4aviation.service.Smart4AviationService;
import pl.smart4aviation.util.Smart4AviationUtility;

/**
 * Implementation of the Interface Smart4AviationService.
 * 
 * @author Pankaj Singh Nirmal
 */

@Service
public class Smart4AviationServiceImpl implements Smart4AviationService
{
	private List<Long> departingFlightIdList = new ArrayList<>();
	private List<Long> arrivingFlightIdList = new ArrayList<>();
	private String requestedFlightId;	// assigning a String variable considering that a 
	// Flight Number with a given date is unique. In case the flight number is not unique, 
	// we must assign the variable as a List.
	
	@Override
	public String getFlightId(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException 
	{
		List<FlightEntity> flightEntity = Smart4AviationUtility.getFlightEntity();
		
		requestedFlightId = "Flight not found !!";
		
		for(int i=0; i<flightEntity.size(); i++) 
		{
			String formattedDate = flightEntity.get(i).getDepartureDate().substring(0, 10);
			
			if(flightEntity.get(i).getFlightNumber().equals(Long.parseLong(requestedDetails.getRequestedFlightNumber()))
					&& formattedDate.equals(requestedDetails.getRequestedFlightDate())) 
				requestedFlightId = flightEntity.get(i).getFlightId().toString();
			
			if(flightEntity.get(i).getDepartureAirportIATACode().equals(requestedDetails.getRequestedAirportCode()) 
					&& formattedDate.equals(requestedDetails.getRequestedAirportDate()))
				departingFlightIdList.add(flightEntity.get(i).getFlightId());
			
			if(flightEntity.get(i).getArrivalAirportIATACode().equals(requestedDetails.getRequestedAirportCode()) 
					&& formattedDate.equals(requestedDetails.getRequestedAirportDate()))
				arrivingFlightIdList.add(flightEntity.get(i).getFlightId());
		}
		
		return requestedFlightId;
	}

	@Override
	public double getCargoWeight(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException 
	{
		// calculate Cargo Weight for requested Flight 
		List<CargoEntity> cargoEntity = Smart4AviationUtility.getCargoEntity();
		
		double cargoWeight = 0;
		
		for(int i=0; i<cargoEntity.get(Integer.parseInt(requestedFlightId)).getCargo().length; i++) 
		{
			// if weight is in lb, then converting it to kg
			if(cargoEntity.get(Integer.parseInt(requestedFlightId)).getCargo()[i].getWeightUnit().equals("lb"))
				cargoWeight += cargoEntity.get(Integer.parseInt(requestedFlightId)).getCargo()[i].getWeight()*0.453592;
			else
				cargoWeight += cargoEntity.get(Integer.parseInt(requestedFlightId)).getCargo()[i].getWeight();
		}
		
		return cargoWeight;
	}

	@Override
	public double getBaggageWeight(RequestedDetails requestedDetails) throws JsonParseException, JsonMappingException, IOException 
	{
		// calculate Baggage Weight for requested Flight
		List<CargoEntity> cargoEntity = Smart4AviationUtility.getCargoEntity();
		
		double baggageWeight = 0;
		
		for(int i=0; i<cargoEntity.get(Integer.parseInt(requestedFlightId)).getBaggage().length; i++) 
		{
			// if weight is in lb, then converting it to kg
			if(cargoEntity.get(Integer.parseInt(requestedFlightId)).getBaggage()[i].getWeightUnit().equals("lb"))
				baggageWeight += cargoEntity.get(Integer.parseInt(requestedFlightId)).getBaggage()[i].getWeight()*0.453592;
			else
				baggageWeight += cargoEntity.get(Integer.parseInt(requestedFlightId)).getBaggage()[i].getWeight();
		}
		
		return baggageWeight;
	}
	
	@Override
	public int getTotalFlightsDeparting() 
	{
		return departingFlightIdList.size();
	}
	
	@Override
	public int getTotalFlightsArriving() 
	{
		return arrivingFlightIdList.size();
	}

	@Override
	public Map<String, Integer> getTotalBaggagePieces() throws JsonParseException, JsonMappingException, IOException 
	{
		List<CargoEntity> cargoEntity = Smart4AviationUtility.getCargoEntity();
		Map<String, Integer> totalBaggagePiecesMap = new HashMap<>();
		int totalBaggagePiecesArriving = 0;
		int totalBaggagePiecesDeparting = 0;
		
		for(int i=0; i<cargoEntity.size(); i++) 
		{
			if(arrivingFlightIdList.contains(cargoEntity.get(i).getFlightId())) 
			{
				for(int j=0; j<cargoEntity.get(i).getBaggage().length; j++) 
					totalBaggagePiecesArriving += cargoEntity.get(i).getBaggage()[j].getPieces();
			}
			
			if(departingFlightIdList.contains(cargoEntity.get(i).getFlightId())) 
			{
				for(int j=0; j<cargoEntity.get(i).getBaggage().length; j++) 
					totalBaggagePiecesDeparting += cargoEntity.get(i).getBaggage()[j].getPieces();
			}
		}
		
		totalBaggagePiecesMap.put("totalBaggagePiecesArriving", totalBaggagePiecesArriving);
		totalBaggagePiecesMap.put("totalBaggagePiecesDeparting", totalBaggagePiecesDeparting);
		
		return totalBaggagePiecesMap;
	}

	@Override
	public void clearFlightIdList() 
	{
		departingFlightIdList.clear();
		arrivingFlightIdList.clear();
	}
	
}
