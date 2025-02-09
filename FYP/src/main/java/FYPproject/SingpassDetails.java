/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-19 9:12:00 pm 
 * 
 */

package FYPproject;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SingpassDetails implements UserDetails {
	
	private Singpass singpass;
	
	public SingpassDetails(Singpass singpass){
		this.singpass = singpass;
	}
	
	public Singpass getsingpass() {
		return singpass;
	}
	
	public void setSingpass(Singpass singpass) {
		this.singpass = singpass;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(singpass.getRole());
        return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return singpass.getPassword();
	}

	@Override
	public String getUsername() {
		return singpass.getEnteredNRIC();
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

