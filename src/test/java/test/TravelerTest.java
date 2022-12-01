package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import travel.beans.Traveler;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Nov 30, 2022  
*/
public class TravelerTest {
	String fname = "Bob";
	String lname = "Builder";
	String relationship = "friend";
	
	Traveler traveler = new Traveler(fname, lname, relationship);

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link travel.beans.Traveler#Traveler(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTravelerStringStringString() {
		assertEquals("Bob", traveler.getFirstName());
		assertEquals("Builder", traveler.getLastName());
		assertEquals("friend", traveler.getRelationship());
	}

	/**
	 * Test method for {@link travel.beans.Traveler#Traveler(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTravelerStringString() {
		assertEquals("Bob", traveler.getFirstName());
		assertEquals("Builder", traveler.getLastName());
	}
	
	/**
	 * Test method for {@link travel.beans.Traveler#Traveler(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testTravelerStringStringFail() {
		assertNotEquals("Bill", traveler.getFirstName());
		assertNotEquals("Batman", traveler.getLastName());
	}

}
