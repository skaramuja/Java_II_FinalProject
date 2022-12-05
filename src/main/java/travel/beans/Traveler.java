package travel.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Traveler {
	
	@Size(min = 2, max = 50, message = "First Name must be between 2 and 50 characters.")
	@NotBlank(message = "Please enter a fist name.")
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Size(min = 2, max = 50, message = "Last Name must be between 2 and 50 characters.")
	@NotBlank(message = "Please enter a last name.")
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="RELATIONSHIP")
	private String relationship;
	

	/**
	 * Constructor that takes first name, last name, and relationship as parameters
	 * @param firstName
	 * @param lastName
	 * @param relationship
	 */
	public Traveler(String firstName, String lastName, String relationship) {
		setFirstName(firstName);
		setLastName(lastName);
		setRelationship(relationship);
	}
	
	/**
	 * Constructor that takes first name, and last name as parameters
	 * @param firstName
	 * @param lastName
	 */
	public Traveler(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}
}