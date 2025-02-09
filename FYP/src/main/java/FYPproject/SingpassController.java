/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-18 9:57:57 pm 
 * 
 */

package FYPproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
public class SingpassController {

	@Autowired
	private SingpassRepository singpassRepository;


	
	@GetMapping("/singpass/add")
	public String addSingpaess(Model model) {
		model.addAttribute("singpass", new Singpass());
		return "add_singpass";
	}
	

	@PostMapping("/singpass/save")
	public String saveSingpass(RedirectAttributes redirectAttribute, @Valid Singpass singpass, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			System.out.println("error");
			return "add_singpass";
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedNRIC = passwordEncoder.encode(singpass.getEnteredNRIC());
		
		singpass.setPassword(encodedNRIC);
		singpass.setRole("ROLE_ADMIN");
		singpassRepository.save(singpass);
		
		redirectAttribute.addFlashAttribute("success", "Singpass registered!");
		
		return "redirect:/login";
	}


}