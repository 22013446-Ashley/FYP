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

import org.springframework.data.jpa.repository.JpaRepository;


public interface SingpassRepository extends JpaRepository<Singpass, Integer> {
	
	public Singpass findByUsername(String name);

	
}