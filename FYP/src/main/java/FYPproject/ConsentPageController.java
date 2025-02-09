/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-27 4:13:33 pm 
 * 
 */

package FYPproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsentPageController {

	@GetMapping("/consentPage")
	public String consentPage() {
		return "consentPage";
	}

}
