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

}
