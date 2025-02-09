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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/form")
public class FormsController {

    @Autowired
    private FormService formService;

    @GetMapping("/get")
    public Optional<Form> getForm(@RequestParam String tradingName) {
        return formService.getCustomerByTradingName(tradingName);
    }
}
