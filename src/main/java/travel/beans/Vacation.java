package travel.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="vacation")
public class Vacation {
	@Id
	@GeneratedValue
	
	@Column(name="ID")
	private int id;
	
	@Size(min = 3, max = 50)
	@NotBlank
	@Column(name="DESTINATION")
	private String destination;
	
	@NotBlank
	@Column(name="STARTDATE")
	private LocalDate startDate;
	
	@NotBlank
	@Column(name="ENDDATE")
	private LocalDate endDate;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@Column(name="ACTIVITIES")
	private List<Activity> activities;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@Column(name="TRAVELERS")
	private List<Traveler> travellers;

	/**
	 * Constructor that takes id, destination, startDate, endDate, activities, and travellers as parameters
	 * @param id
	 * @param destination
	 * @param startDate
	 * @param endDate
	 * @param activities
	 * @param travellers
	 */
	public Vacation(int id, String destination, LocalDate startDate, LocalDate endDate,
			List<Activity> activities, List<Traveler> travellers) {
		setId(id);
		setDestination(destination);
		setStartDate(startDate);
		setEndDate(endDate);
		setActivities(activities);
		setTravellers(travellers);
	}
	
	/**
	 * Constructor that takes destination, startDate, endDate, activities, and travellers as parameters
	 * @param destination
	 * @param startDate
	 * @param endDate
	 * @param activities
	 * @param travellers
	 */
	public Vacation(String destination, LocalDate startDate, LocalDate endDate,
			List<Activity> activities, List<Traveler> travellers) {
		setDestination(destination);
		setStartDate(startDate);
		setEndDate(endDate);
		setActivities(activities);
		setTravellers(travellers);
	}
	
	/**
	 * Constructor that takes destination, startDate, endDate, and travellers as parameters
	 * @param destination
	 * @param startDate
	 * @param endDate
	 * @param travellers
	 */
	public Vacation(String destination, LocalDate startDate, LocalDate endDate,
			List<Traveler> travellers) {
		setDestination(destination);
		setStartDate(startDate);
		setEndDate(endDate);
		setActivities(activities);
		setTravellers(travellers);
	}
	
	/**
	 * Constructor that takes destination, startDate, and endDate as parameters
	 * @param destination
	 * @param startDate
	 * @param endDate
	 */
	public Vacation(String destination, LocalDate startDate, LocalDate endDate) {
		setDestination(destination);
		setStartDate(startDate);
		setEndDate(endDate);
		setActivities(activities);
	}
}