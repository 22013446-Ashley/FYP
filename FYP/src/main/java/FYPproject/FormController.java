package FYPproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FormController {
	
	@Autowired
	private FormRepository formRepository;

	
	@GetMapping("/application-data/{id}")
    public ResponseEntity<Form> getApplicationData(@PathVariable Long id) {
        return formRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}