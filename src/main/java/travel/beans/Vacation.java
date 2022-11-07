package travel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vacation")
public class Vacation {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="STATE")
	private String state;
	@Column(name="CITY")
	private String city;
	@Column(name="ACTIVITY")
	private Activity activity;
	@Column(name="TRAVELER")
	private Traveler traveler;
	/**
	 * @param country
	 * @param state
	 * @param city
	 * @param activity
	 * @param traveler
	 */
	public Vacation(String country, String state, String city, Activity activity, Traveler traveler) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.activity = activity;
		this.traveler = traveler;
	}
	/**
	 * 
	 */
	public Vacation() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}
	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	/**
	 * @return the traveler
	 */
	public Traveler getTraveler() {
		return traveler;
	}
	/**
	 * @param traveler the traveler to set
	 */
	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}
	@Override
	public String toString() {
		return "Vacation [id=" + id + ", country=" + country + ", state=" + state + ", city=" + city + ", activity="
				+ activity + ", traveler=" + traveler + "]";
	}
	

}
