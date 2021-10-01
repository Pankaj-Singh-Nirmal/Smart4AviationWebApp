package pl.smart4aviation.model;

import java.util.Arrays;

/**
 * A model class which is used to store the information of the Cargo such as flightId, 
 * baggage info and cargo info from JSON file.
 * 
 * @author Pankaj Singh Nirmal
 */

public class CargoEntity 
{
	private Long flightId;
	private Baggage[] baggage;
	private Cargo[] cargo;
	
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
	 * @return  returns the Baggage info mapped to the JSON file
	 */
	public Baggage[] getBaggage() {
		return baggage;
	}
	/**
	 * @param  baggage 
	 * 		   Baggage info mapped to the JSON file		   
	 */
	public void setBaggage(Baggage[] baggage) {
		this.baggage = baggage;
	}
	/**
	 * @return  returns the Cargo info mapped to the JSON file
	 */
	public Cargo[] getCargo() {
		return cargo;
	}
	/**
	 * @param  cargo 
	 * 		   Cargo info mapped to the JSON file		   
	 */
	public void setCargo(Cargo[] cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "CargoEntity [flightId=" + flightId + ", baggage=" + Arrays.toString(baggage) + ", cargo="
				+ Arrays.toString(cargo) + "]";
	}
}
