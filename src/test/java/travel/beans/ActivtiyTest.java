package travel.beans;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class ActivtiyTest {
	String name = "Swimming";
	LocalDate date = LocalDate.now();
	String description = "Swimming in a pool";
	int id = 1;
	
	Activity activity1 = new Activity(id, name, date, description);
	Activity activity2 = new Activity();
	
	

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
	
	@Test
	void testGetId() {
		activity2.setId(2);
		assertEquals(2, activity2.getId());
	}
	
	@Test
	void testGetName() {
		activity2.setName("House Building");
		assertEquals("House Building", activity2.getName());
	}
	
	@Test
	void testGetDate() {
		LocalDate date2 = LocalDate.now();
		activity2.setDate(date2);
		assertEquals(date2, activity2.getDate());
	}
	
	@Test
	void testGetDescription() {
		activity2.setDescription("Building a house");
		assertEquals("Building a house", activity2.getDescription());
	}

}
