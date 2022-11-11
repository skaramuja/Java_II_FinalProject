package travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import travel.beans.Vacation;
import travel.repository.VacationRepository;

@Controller
public class VacationController {
	@Autowired
	VacationRepository repo;
	
	/**
	 * Displays the Results page if vacation exists in the database otherwise displays add page
	 * @param model
	 * @return myTrips page
	 */
	@GetMapping({ "/", "vacations" })
	public String viewAllVacations(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewVacation(model);
		}
		model.addAttribute("vacation", repo.findAll());
		return "myTrips";
	}

	/**
	 * Displays the add vacation page
	 * @param model
	 * @return planYourTrip page
	 */
	@GetMapping("/createVacation")
	public String addNewVacation(Model model) {
		Vacation vacation = new Vacation();
		model.addAttribute("newVacation", vacation);
		return "planYourTrip";
	}

	/**
	 * Saves the new vacation and redirect to the view all
	 * @param vacation
	 * @param model
	 * @return viewAllVacations(model)
	 */
	@PostMapping("/createVacation")
	public String addNewVacation(@ModelAttribute Vacation vacation, Model model) {
		repo.save(vacation);
		return viewAllVacations(model);
	}

	/**
	 * Displays add/edit page for the vacation matching the id
	 * @param id
	 * @param model
	 * @return planYourTrip page
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateVacation(@PathVariable("id") long id, Model model) {
		Vacation vacation = repo.findById(id).orElse(null);
		model.addAttribute("newVacation", vacation);
		return "planYourTrip";
	}

	/**
	 * Redirects the user to the myTrips page
	 * @param vacation
	 * @param model
	 * @return A redirect view to the myTrips page
	 */
	@PostMapping("/update/{id}") 
	public RedirectView reviseVacation(Vacation vacation, Model model) {
		repo.save(vacation);
		return new RedirectView("../myTrips");
	}
	
	/**
	 * Deletes selected vacation from database matching using id
	 * @param id
	 * @param model
	 * @return viewAllVacations(model)
	 */
	@GetMapping("/delete/{id}")
	public String deleteVacation(@PathVariable("id") long id, Model model) {
		Vacation vacation = repo.findById(id).orElse(null);
		repo.delete(vacation);
		return viewAllVacations(model);

	}
	
	/**
	 * Displays index page
	 * @return index
	 */
	@RequestMapping("/index")
	public String index(){
	    return "index";
	}
	
	/**
	 * Displays planYourTrip page
	 * @param model
	 * @return planYourTrip
	 */
	@RequestMapping("/planYourTrip")
	public String planYourTrip(Model model){
		model.addAttribute("newVacation", new Vacation());
	    return "planYourTrip";
	}
	
	/**
	 * Displays myTrips page
	 * @return myTrips
	 */
	@RequestMapping("/myTrips")
	public String myTrips(Model model){
		if (repo.findAll().isEmpty()) {
			return addNewVacation(model);
		}
		model.addAttribute("vacation", repo.findAll());
		return "myTrips";
	}


}
