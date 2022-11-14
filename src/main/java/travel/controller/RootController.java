package travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
	/**
	 * Displays the index page
	 * @param model
	 * @return index
	 */
	@GetMapping("/")
	public String viewAllVacations(Model model) {
		return "index";
	}

}
