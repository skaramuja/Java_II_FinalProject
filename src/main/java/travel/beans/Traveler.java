package travel.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="travelers")
public class Traveler {
	@Id
	@GeneratedValue
	private int id;
	private String travelersName;
	/**
	 * 
	 */
	public Traveler() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param travelersName
	 */
	public Traveler(String travelersName) {
		super();
		this.travelersName = travelersName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the travelersName
	 */
	public String getTravelersName() {
		return travelersName;
	}
	/**
	 * @param travelersName the travelersName to set
	 */
	public void setTravelersName(String travelersName) {
		this.travelersName = travelersName;
	}
	@Override
	public String toString() {
		return "Traveler [id=" + id + ", travelersName=" + travelersName + "]";
	}
	
	
}
