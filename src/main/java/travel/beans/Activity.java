package travel.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Activity")
public class Activity {
	@Id
	@GeneratedValue
	
	@Column(name="ID")
	private int id;
	
	@Size(min = 3, max = 50, message = "Activity Name must be between 3 and 50 characters.")
	@NotBlank(message = "Please enter in activity name.")
	@Column(name="NAME")
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Please enter a date for activity.")
	@Column(name="DATE")
	private LocalDate date;
	
	@Size(min = 3, max = 100, message = "Enter a description of the activity.")
	@Column(name="DESCRIPTION")
	private String description;
	
	/**
	 * Constructor that takes id, date, and description as parameters
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 */
	public Activity(int id, String name, LocalDate date, String description) {
		setId(id);
		setName(name);
		setDate(date);
		setDescription(description);
	}
	
	/**
	 * Constructor that takes name, date, and description as parameters
	 * @param name
	 * @param date
	 * @param description
	 */
	public Activity(String name, LocalDate date, String description) {
		setName(name);
		setDate(date);
		setDescription(description);
	}
	
	/**
	 * Constructor that takes name and date as parameters
	 * @param name
	 * @param date
	 */
	public Activity(String name, LocalDate date) {
		setName(name);
		setDate(date);
	}
}
