package pl.smart4aviation.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pl.smart4aviation.model.RequestedDetails;
import pl.smart4aviation.service.Smart4AviationService;

/**
 * Controller of the application. RequestDispatcher accepts the client request and
 * redirect it to this class' appropriate method as per the @GetMapping annotation.
 * 
 * @author Pankaj Singh Nirmal
 */

@Controller
public class MainController 
{
	@Autowired
	Smart4AviationService smart4AviationService;
	
	/**
	 * Maps the request for root URL and returns the view for home page.
	 * 
	 * @param  requestedDetails 
	 * 		   Binds to named model attribute calculation, exposed to the web view of 
	 * 		   home-page.jsp
	 * 
	 * @return  returns the view for home-page.jsp
	 */
	@GetMapping("/")
	public String loadHomePage(@ModelAttribute("calculation") RequestedDetails requestedDetails) 
	{
		return "home-page";
	}
	
	/**
	 * Maps the request for /processCalculation and returns the view for home page with 
	 * calculated data.
	 * 
	 * @param  requestedDetails 
	 * 		   Binds to named model attribute calculation, exposed to the web view of 
	 * 		   home-page.jsp
	 * 
	 * @param  result 
	 * 		   Holds the result of the validation and binding containing errors that may 
	 * 		   have occurred
	 * 
	 * @param  model 
	 * 		   Adds the supplied attribute under the supplied name
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
	 * @return  returns the view for home-page.jsp
	 */
	@GetMapping("/processCalculation")
	public String loadCalculationPage(@Valid @ModelAttribute("calculation") RequestedDetails requestedDetails,
									  BindingResult result, Model model) 
									  throws JsonParseException, JsonMappingException, IOException
	{	
		if(result.hasErrors())
		{
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError err : allErrors) 
				System.out.println(err);
			
			return "home-page";
		}
		
		// converting user input for IATA airport code to upper-case
		requestedDetails.setRequestedAirportCode(requestedDetails.getRequestedAirportCode().toUpperCase());
		
		String flightId = smart4AviationService.getFlightId(requestedDetails);
		model.addAttribute("flightId", flightId);
		
		// Task 1
		if(flightId != "Flight not found !!") 
		{
			double cargoWeight = smart4AviationService.getCargoWeight(requestedDetails);
			double baggageWeight = smart4AviationService.getBaggageWeight(requestedDetails);
			double totalWeight = cargoWeight + baggageWeight;
			model.addAttribute("cargoWeight", String.format("%.2f",cargoWeight))
				 .addAttribute("baggageWeight", String.format("%.2f",baggageWeight))
				 .addAttribute("totalWeight", String.format("%.2f",totalWeight));
		}
		
		// Task 2
		int totalFlightsDeparting = smart4AviationService.getTotalFlightsDeparting();
		int totalFlightsArriving = smart4AviationService.getTotalFlightsArriving();
		Map<String, Integer> totalBaggagePieces = smart4AviationService.getTotalBaggagePieces();
		
		model.addAttribute("totalFlightsDeparting", totalFlightsDeparting)
			 .addAttribute("totalFlightsArriving", totalFlightsArriving)
			 .addAttribute("totalBaggagePiecesArriving", totalBaggagePieces.get("totalBaggagePiecesArriving"))
			 .addAttribute("totalBaggagePiecesDeparting", totalBaggagePieces.get("totalBaggagePiecesDeparting"));
		
		smart4AviationService.clearFlightIdList();
		
		return "home-page";
	}
}
