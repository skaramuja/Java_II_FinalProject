package travel.controller;

import java.util.ArrayList;
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

@RequestMapping("vacations/{id}")
@Controller
public class ActivityController {

	@Autowired
	ActivityRepository activityRepo;
	
	@Autowired
	VacationRepository vacationRepo;
	
	/**
	 * Displays a activities based on its id to edit
	 * @param model
	 * @return creatingActivity
	 */
	@GetMapping("/editActivity/{activityId}")
	public String viewActivity(@PathVariable("id") int id, @PathVariable("activityId") int activityId, Model model) {
		Activity activity = activityRepo.findById(activityId).orElse(null);
		model.addAttribute("newActivity", activity);
		model.addAttribute("vacationId", id);
		return ("creatingActivity");
	}
	
	
	/**
	 * Save a activity
	 * @param activity
	 * @param model
	 * @param bindingResult
	 * @return activities
	 */
	@PostMapping("/newActivity")
	public String saveActivity(@Valid @ModelAttribute("newActivity") Activity activity, @PathVariable("id") int id, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("newActivity", activity);
			return "creatingActivity";
		}
		
		// Don't always add the activity to the database and update. We need to figure out, using the activityID, if the activity already exists in the list. If it does, we need to update it in the list.
		Vacation vacation = vacationRepo.findById(id).orElse(null);

		List<Activity> activities = vacation.getActivities();
		int indexOfExistingActivity = -1;
		for(int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			if(currentActivity.getId() == activity.getId()) {
				indexOfExistingActivity = i;
			}
		}
		if(indexOfExistingActivity == -1) {
			activities.add(activity);
		} else {
			activities.set(indexOfExistingActivity, activity);
		}
		vacation.setActivities(activities);
		vacationRepo.save(vacation);
		
		//activityRepo.save(activity);
		return "redirect:/vacations/details/{id}";
	}
	
	
	/**
	 * Add a new activity
	 * @param model
	 * @return activities
	 */
	@GetMapping("/newActivity")
	public String addNewActivity(@PathVariable("id") int id, Model model) {
		model.addAttribute("newActivity", new Activity());
		model.addAttribute("vacationId", id);
		return "creatingActivity";
	}
	
	/**
	 * Delete an activity
	 * @param id
	 * @return activities
	 */
	@GetMapping("/delete/{activityId}")
	public String deleteActivity(@PathVariable("id") int id, @PathVariable("activityId") int activityId) {
		Activity activity = activityRepo.findById(activityId).orElse(null);
		
		// Find the activity in the vacation activities and delete it from the list. 
		Vacation vacation = vacationRepo.findById(id).orElse(null);
		List<Activity> currentActivities = vacation.getActivities();
		List<Activity> newActivities = new ArrayList<Activity>(); 
		for(int i = 0; i < currentActivities.size(); i++) {
			Activity currentActivity = currentActivities.get(i);
			if(currentActivity.getId() != activityId) {
				newActivities.add(currentActivity);
			}
		}
		
		vacation.setActivities(newActivities);
		// Save the vacation without the activity
		vacationRepo.save(vacation);
		
		// Now it's safe to delete the activity
		activityRepo.delete(activity);
		return "redirect:/vacations/details/{id}";
	}
}
