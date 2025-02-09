/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-18 10:12:41 pm 
 * 
 */
package FYPproject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SingpassDetailsService singpassDetailsService() {
		return new SingpassDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(singpassDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	        .requestMatchers("/form","/form/submit,","/submit").hasRole("ADMIN")
        	.requestMatchers("/home","/consentPage","/singpass/add","/singpass/save","/proxy/person-sample","/application-data/","/api","api/excel/form-data").permitAll() //Home page and SINGPASS login is visible without logging in
        	.requestMatchers("/bootstrap/*/*").permitAll() //for static resources, visible to all
        	.requestMatchers("/images/*").permitAll() //for static resources, visible to all
            .anyRequest().authenticated()//Other requests such as to view an item with id 1: /items/1            
			) //end of authorizeHttpRequests 
		.formLogin((login) -> login.loginPage("/login").permitAll().defaultSuccessUrl("/")) //Goes to homepage upon login
		.logout((logout) -> logout.logoutSuccessUrl("/home")) //Goes to homepage upon logout					        
		.exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedPage("/403"));

		return http.build();
	}

}

