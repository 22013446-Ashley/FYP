/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-18 10:00:14 pm 
 * 
 */
package FYPproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;



@RestController
public class ProxyController {

	@GetMapping("/proxy/person-sample")
	public ResponseEntity<String> getPersonSpecificSample() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://sandbox.api.myinfo.gov.sg/com/v4/person-sample/S9812381D";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response;
	}

	@GetMapping("/proxy/person-sample/{uinfin}")
	public ResponseEntity<String> getPersonSample(@PathVariable String uinfin) {
	    RestTemplate restTemplate = new RestTemplate();
	    String url = "https://sandbox.api.myinfo.gov.sg/com/v4/person-sample/" + uinfin;
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        return response;
	}

}
