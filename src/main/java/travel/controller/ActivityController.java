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

import travel.beans.Activity;
import travel.repository.ActivityRepository;

@RequestMapping("myActivities")
@Controller
public class ActivityController {

	@Autowired
	ActivityRepository repo;
	
	@GetMapping("")
	public String viewAllActivities(Model model) {
		model.addAttribute("activities", repo.findAll());
		return "myActivities";
	}
	
	
	@GetMapping("/{id}")
	public String viewActivity(@PathVariable("id") int id, Model model) {
		Activity activity = repo.findById(id).orElse(null);
		model.addAttribute("newActivity", activity);
		return ("creatingActivity");
	}
	
	@PostMapping("/{id}")
	public RedirectView saveActivity(@ModelAttribute Activity activity) {
		repo.save(activity);
		return new RedirectView("../myActivities");
	}
	@GetMapping("/new")
	public String addNewActivity(Model model) {
		model.addAttribute("newActivity", new Activity());
		return "creatingActivity";
	}

}
