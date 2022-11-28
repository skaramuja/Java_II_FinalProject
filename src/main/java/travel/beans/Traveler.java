package travel.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="travelers")
public class Traveler {
	@Id
	@GeneratedValue
	
	@Column(name="ID")
	private int id;
	
	@Size(min = 3, max = 50)
	@NotBlank
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Size(min = 3, max = 50)
	@NotBlank
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="RELATIONSHIP")
	private String relationship;
	

	/**
	 * Constructor that takes id, firstname, lastname, and relationship as parameters
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param relationship
	 */
	public Traveler(int id, String firstName, String lastName, String relationship) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setRelationship(relationship);
	}
	
	/**
	 * Constructor that takes id, firstname, lastname, and relationship as parameters
	 * @param id
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
	 * Constructor that takes id, firstname, and lastname as parameters
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public Traveler(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}	
}