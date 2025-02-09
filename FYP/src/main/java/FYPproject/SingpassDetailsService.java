/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-19 9:18:15 pm 
 * 
 */

package FYPproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SingpassDetailsService implements UserDetailsService{

	@Autowired
	private SingpassRepository singpassRepository;
	
	@Override
	public SingpassDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Singpass singpass = singpassRepository.findByUsername(username);
		
		if (singpass == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new SingpassDetails(singpass);
		}
	}
