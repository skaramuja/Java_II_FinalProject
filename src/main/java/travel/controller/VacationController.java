package travel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import travel.beans.Activity;
import travel.beans.Vacation;
import travel.repository.ActivityRepository;
import travel.repository.VacationRepository;

@RequestMapping("vacations")
@Controller
public class VacationController {
	@Autowired
	VacationRepository vacationRepo;
	
	@Autowired
	ActivityRepository activityRepo;
	

	/**
	 * Displays all vacations
	 * @param model
	 * @return myTrips
	 */
	@GetMapping("")
	public String viewAllVacations(Model model) {
		model.addAttribute("vacation", vacationRepo.findAll());
		return "myTrips";
	}
	
	/**
	 * Displays a vacation based on its id to edit
	 * @param id
	 * @param model
	 * @return planYourTrip
	 */
	@GetMapping("/{id}")
	public String viewVacation(@PathVariable("id") int id, Model model) {
		Vacation vacation = vacationRepo.findById(id).orElse(null);
		model.addAttribute("newVacation", vacation);
		return ("planYourTrip");
	}
	
	/**
	 * Save a vacation
	 * @param vacation
	 * @param bindingResult
	 * @param model
	 * @return myTrips
	 */
	@PostMapping("/{id}")
	public String saveVacation(@Valid @ModelAttribute("newVacation") Vacation vacation, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("newVacation", vacation);
			return "planYourTrip";
		}
		vacationRepo.save(vacation);
		return "redirect:/vacations";
	}
	

	/**
	 * Delete a vacation
	 * @param id
	 * @return myTrips
	 */
	@GetMapping("/delete/{id}")
	public String deleteVacation(@PathVariable("id") int id) {
		Vacation vacation = vacationRepo.findById(id).orElse(null);
		vacationRepo.delete(vacation);
		return "redirect:/vacations";
	}
	
	/**
	 * Vacation details
	 * @param id
	 * @param model
	 * @return vacationDetails
	 */
	@GetMapping("/details/{id}")
	public String viewVacationDetails(@PathVariable("id") int id, Model model) {
		Vacation vacation = vacationRepo.findById(id).orElse(null);
		model.addAttribute("vacation", vacation);
		
		List<Activity> activities = activityRepo.findAll();
		model.addAttribute("allActivities", activities);
		return "vacationDetails";
	}
	
	/**
	 * Add a new vacations
	 * @param model
	 * @return planYourTrip
	 */
	@GetMapping("/new")
	public String newVacation(Model model) {
		Vacation vacation = new Vacation();
		model.addAttribute("newVacation", vacation);
		return ("planYourTrip");
	}
}
