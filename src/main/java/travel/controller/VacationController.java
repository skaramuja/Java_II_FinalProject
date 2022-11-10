package travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import travel.beans.Vacation;
import travel.repository.VacationRepository;

@Controller
public class VacationController {
	@Autowired
	VacationRepository repo;
	
	/**
	 * Displays the Results page if vacation exists in the database otherwise displays Input page
	 * @param model
	 * @return Results page
	 */
	@GetMapping({ "/", "viewAll" })
	public String viewAllVacations(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewVacation(model);
		}
		model.addAttribute("vacation", repo.findAll());
		return "index";
	}

	/**
	 * Displays the Input page
	 * @param model
	 * @return Input page
	 */
	@GetMapping("/inputConcert")
	public String addNewVacation(Model model) {
		Vacation vacation = new Vacation();
		model.addAttribute("newVacation", vacation);
		return "index";
	}

	/**
	 * Saves the new vacation and redirect to the view all
	 * @param vacation
	 * @param model
	 * @return viewAllVacations(model)
	 */
	@PostMapping("/inputVacation")
	public String addNewVacation(@ModelAttribute Vacation vacation, Model model) {
		repo.save(vacation);
		return viewAllVacations(model);
	}

	/**
	 * Displays Input page for the vacation matching the id
	 * @param id
	 * @param model
	 * @return Input page
	 */
	@GetMapping("/edit/{id}")
	public String showUpdateVacation(@PathVariable("id") long id, Model model) {
		Vacation vacation = repo.findById(id).orElse(null);
		model.addAttribute("newVacation", vacation);
		return "index";
	}

	/**
	 * Updates the vacation based on user input
	 * @param vacation
	 * @param model
	 * @return viewAllVacations(model)
	 */
	@PostMapping("/update/{id}")
	public String reviseVacation(Vacation vacation, Model model) {
		repo.save(vacation);
		return viewAllVacations(model);
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
}
