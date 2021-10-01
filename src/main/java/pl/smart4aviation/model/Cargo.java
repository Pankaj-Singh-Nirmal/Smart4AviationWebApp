package pl.smart4aviation.model;

/**
 * A model class which is used to store the information of the cargo such as id, 
 * weight, weightUnit and pieces from JSON file.
 * 
 * @author Pankaj Singh Nirmal
 */

public class Cargo 
{
	private Long id;
	private int weight;
	private String weightUnit;
	private int pieces;
	
	/**
	 * @return  returns the id of the cargo mapped to the JSON file
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param  id 
	 * 		   Id of the cargo mapped to the JSON file	   
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return  returns the Weight of the cargo mapped to the JSON file
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param  weight 
	 * 		   Weight of the cargo mapped to the JSON file		   
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return  returns the Weight unit of the cargo mapped to the JSON file	
	 */
	public String getWeightUnit() {
		return weightUnit;
	}
	/**
	 * @param  weightUnit 
	 * 		   Weight unit of the cargo mapped to the JSON file	   
	 */
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	/**
	 * @return  returns the number of pieces of cargo mapped to the JSON file
	 */
	public int getPieces() {
		return pieces;
	}
	/**
	 * @param  pieces 
	 * 		   Number of pieces of cargo mapped to the JSON file	   
	 */
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", weight=" + weight + ", weightUnit=" + weightUnit + ", pieces=" + pieces + "]";
	}
}
