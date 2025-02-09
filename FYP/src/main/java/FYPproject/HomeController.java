package FYPproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String file() {
		return "index";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "403";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}


