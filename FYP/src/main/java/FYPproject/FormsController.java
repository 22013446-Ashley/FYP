/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Feb-07 11:41:48 am 
 * 
 */

package FYPproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class FormsController {
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("form", new Form());
		return "form";
	}

	@PostMapping("/form/submit")
	public String submitForm(@Valid @ModelAttribute("form") Form form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "form";
		}
		System.out.println("Form submitted: " + form);
		model.addAttribute("message", "Form submitted successfully!");
		return "success";
	}

}
