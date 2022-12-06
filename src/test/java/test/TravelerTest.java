package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import travel.beans.Traveler;

public class TravelerTest {
	String fname = "Bob";
	String lname = "Builder";
	String relationship = "friend";
	
	Traveler traveler = new Traveler(fname, lname, relationship);
	Traveler traveler2 = new Traveler();

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
	
	@Test
	void testGettingFirstName() {
		traveler2.setFirstName("Frank");
		assertEquals("Frank", traveler2.getFirstName());
	}
	
	@Test
	void testGettingLastName() {
		traveler2.setLastName("Castle");
		assertEquals("Castle", traveler2.getLastName());
	}
	
	@Test
	void testGettingRelationship() {
		traveler2.setRelationship("Friend");
		assertEquals("Friend", traveler2.getRelationship());
	}
	

}
