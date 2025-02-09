/**
 * 
 * I declare that this code was written by me, lucas. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lucas
 * Student ID: 22026220
 * Class: E63C
 * Date created: 2023-10-25, 09:01AM
 * 
 */
package FYPproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
	
}
