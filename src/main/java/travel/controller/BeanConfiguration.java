package travel.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import travel.beans.Vacation;
import travel.beans.Traveler;
import travel.beans.Activity;


@Configuration
public class BeanConfiguration {
	@Bean
	public Vacation vacation() {
		LocalDate startDate = LocalDate.of(2022, 11, 06);
		LocalDate endDate = LocalDate.of(2022, 11, 10);
		Vacation vacation = new Vacation("Home", "Des Moines", startDate,endDate);
		return vacation;
	}

	@Bean
	public Traveler Traveler() {
		Traveler traveler = new Traveler("Tom", "Brady");
		return traveler;
	}
	
	@Bean
	public Activity Activity() {
		LocalDate date = LocalDate.of(2022, 11, 06);
		Activity activity = new Activity("Golfing", date, "Des Moines Country Club at 7AM");
		return activity;
	}
}