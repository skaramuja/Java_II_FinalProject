package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import travel.beans.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Nov 30, 2022  
*/
public class ActivtiyTest {
	String name = "Swimming";
	LocalDate date = LocalDate.now();
	String description = "Swimming in a pool";
	int id = 1;
	
	Activity activity1 = new Activity(id, name, date, description);
	Activity activity2 = new Activity(name, date, description);
	Activity activity3 = new Activity(name, date);
	

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link travel.beans.Activity#Activity(int, java.lang.String, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	void testActivityIntStringLocalDateString() {
		assertEquals(1, activity1.getId());
		assertEquals("Swimming", activity1.getName());
		assertEquals(LocalDate.now(), activity1.getDate());
		assertEquals("Swimming in a pool", activity1.getDescription());
		
	}

	/**
	 * Test method for {@link travel.beans.Activity#Activity(java.lang.String, java.time.LocalDate, java.lang.String)}.
	 */
	@Test
	void testActivityStringLocalDateString() {
		assertEquals("Swimming", activity1.getName());
		assertEquals(LocalDate.now(), activity1.getDate());
		assertEquals("Swimming in a pool", activity1.getDescription());
		
	}
	
	
	/**
	 * Test method for {@link travel.beans.Activity#Activity(java.lang.String, java.time.LocalDate)}.
	 */
	@Test
	void testActivityStringLocalDate() {
		assertEquals("Swimming", activity1.getName());
		assertEquals(LocalDate.now(), activity1.getDate());
	}

	/**
	 * Test method for {@link travel.beans.Activity#Activity(java.lang.String, java.time.LocalDate)}.
	 */
	@Test
	void testActivityStringLocalDateFail() {
		assertNotEquals("Bowling", activity1.getName());
		assertNotEquals(LocalDate.of(2020, 05, 15), activity1.getDate());
	}

}
