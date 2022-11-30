package travel.controller;

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
import org.springframework.web.servlet.view.RedirectView;

import travel.beans.Activity;
import travel.beans.Vacation;
import travel.repository.ActivityRepository;

@RequestMapping("myActivities")
@Controller
public class ActivityController {

	@Autowired
	ActivityRepository repo;
	
	/**
	 * Displays all activities
	 * @param model
	 * @return activities
	 */
	@GetMapping("")
	public String viewAllActivities(Model model) {
		model.addAttribute("activities", repo.findAll());
		return "myActivities";
	}
	
	/**
	 * Displays a activities based on its id to edit
	 * @param model
	 * @return creatingActivity
	 */
	@GetMapping("/{id}")
	public String viewActivity(@PathVariable("id") int id, Model model) {
		Activity activity = repo.findById(id).orElse(null);
		model.addAttribute("newActivity", activity);
		return ("creatingActivity");
	}
	
	
	/**
	 * Save a activity
	 * @param activity
	 * @param model
	 * @param bindingResult
	 * @return activities
	 */
	@PostMapping("/{id}")
	public String saveActivity(@Valid @ModelAttribute("newActivity") Activity activity, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("newActivity", activity);
			return "creatingActivity";
		}
		repo.save(activity);
		return "redirect:/myActivities";
	}
	
	
	/**
	 * Add a new activity
	 * @param model
	 * @return activities
	 */
	@GetMapping("/new")
	public String addNewActivity(Model model) {
		model.addAttribute("newActivity", new Activity());
		return "creatingActivity";
	}
	
	/**
	 * Delete an activity
	 * @param id
	 * @return activities
	 */
	@GetMapping("/delete/{id}")
	public String deleteActivity(@PathVariable("id") int id) {
		Activity activity = repo.findById(id).orElse(null);
		repo.delete(activity);
		return "redirect:/myActivities";
	}
}
