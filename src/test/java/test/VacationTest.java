
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import travel.beans.Activity;
import travel.beans.Traveler;
import travel.beans.Vacation;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Nov 30, 2022  
*/
public class VacationTest {
	int id = 1;
	String name = "BirthDay Trip";
	String destination = "Pool and bowling ally";
	LocalDate startdate = LocalDate.of(2022, 11, 10);
	LocalDate enddate = LocalDate.of(2022, 11, 15);
	Activity activity1 = new Activity("Bowling", LocalDate.now());
	Activity activity2 = new Activity("Swimming", LocalDate.now());
	List<Activity> activities = new ArrayList<Activity>();
	
	Vacation vacation = new Vacation(id, name, destination, startdate, enddate, activities);
	Vacation vacation2 = new Vacation();
	Activity activity3 = new Activity("BaseBall", LocalDate.now());
	Activity activity4 = new Activity("BasketBall", LocalDate.now());
	List<Activity> activities2 = new ArrayList<Activity>();
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link travel.beans.Vacation#Vacation(int, java.lang.String, java.lang.String, java.time.LocalDate, java.time.LocalDate, java.util.List, java.util.List)}.
	 */
	@Test
	void testVacationIntStringStringLocalDateLocalDateListOfActivityListOfTraveler() {
		activities.add(activity1);
		activities.add(activity2);
		assertEquals(1, vacation.getId());
		assertEquals("BirthDay Trip", vacation.getName());
		assertEquals("Pool and bowling ally", vacation.getDestination());
		assertEquals(LocalDate.of(2022, 11, 10), vacation.getStartDate());
		assertEquals(LocalDate.of(2022, 11, 15), vacation.getEndDate());
		assertEquals(activities, vacation.getActivities());
		
	}

	/**
	 * Test method for {@link travel.beans.Vacation#Vacation(java.lang.String, java.lang.String, java.time.LocalDate, java.time.LocalDate, java.util.List, java.util.List)}.
	 */
	@Test
	void testVacationStringStringLocalDateLocalDateListOfActivityListOfTraveler() {
		activities.add(activity1);
		activities.add(activity2);
		assertEquals("BirthDay Trip", vacation.getName());
		assertEquals("Pool and bowling ally", vacation.getDestination());
		assertEquals(LocalDate.of(2022, 11, 10), vacation.getStartDate());
		assertEquals(LocalDate.of(2022, 11, 15), vacation.getEndDate());
		assertEquals(activities, vacation.getActivities());
	}

	/**
	 * Test method for {@link travel.beans.Vacation#Vacation(java.lang.String, java.lang.String, java.time.LocalDate, java.time.LocalDate, java.util.List)}.
	 */
	@Test
	void testVacationStringStringLocalDateLocalDateListOfTraveler() {
		assertEquals("BirthDay Trip", vacation.getName());
		assertEquals("Pool and bowling ally", vacation.getDestination());
		assertEquals(LocalDate.of(2022, 11, 10), vacation.getStartDate());
		assertEquals(LocalDate.of(2022, 11, 15), vacation.getEndDate());
		assertEquals(activities, vacation.getActivities());
	}

	/**
	 * Test method for {@link travel.beans.Vacation#Vacation(java.lang.String, java.lang.String, java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	void testVacationStringStringLocalDateLocalDate() {
		assertEquals("BirthDay Trip", vacation.getName());
		assertEquals("Pool and bowling ally", vacation.getDestination());
		assertEquals(LocalDate.of(2022, 11, 10), vacation.getStartDate());
		assertEquals(LocalDate.of(2022, 11, 15), vacation.getEndDate());
	}
	
	/**
	 * Test method for {@link travel.beans.Vacation#Vacation(java.lang.String, java.lang.String, java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	void testVacationStringStringLocalDateLocalDateFail() {
		assertNotEquals("Birth Trip", vacation.getName());
		assertNotEquals("Pools and bowling ally", vacation.getDestination());
		assertNotEquals(LocalDate.of(2022, 12, 10), vacation.getStartDate());
		assertNotEquals(LocalDate.of(2022, 11, 16), vacation.getEndDate());
	}
	
	@Test
	void testGetterTripsName() {
		vacation2.setName("Zoo Trip");
		assertEquals("Zoo Trip", vacation2.getName());
	}
	
	@Test
	void testGetterTripsID() {
		vacation2.setId(2);
		assertEquals(2, vacation2.getId());
	}
	
	@Test
	void testGetterTripsDestination() {
		vacation2.setDestination("Omaha Zoo");
		assertEquals("Omaha Zoo", vacation2.getDestination());
	}
	
	@Test
	void testGetterTripsStartDate() {
		LocalDate date2 = LocalDate.now();
		vacation2.setStartDate(date2);
		assertEquals(date2, vacation2.getStartDate());
	}
	
	@Test
	void testGetterTripsEndDate() {
		LocalDate date2 = LocalDate.of(2022, 12, 7);
		vacation2.setEndDate(date2);
		assertEquals(date2, vacation2.getEndDate());
	}
	
	@Test
	void testGetterTripsActivities() {
		activities2.add(activity3);
		activities2.add(activity4);
		vacation2.setActivities(activities2);
		assertEquals(activities2, vacation2.getActivities());
		
	}
	
	
}
