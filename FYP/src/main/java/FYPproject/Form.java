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


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "excel_info")
public class Form {
	
	@NotEmpty(message = "Customer name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String custNameTX;
	
	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tradingName;
	private String ctcName;
	private String phoneNum;
	// Constructors 
	public Form() {
	}

	public Form(String custNameTX, String email, String tradingName, String ctcName,
			String phoneNum) {
		this.custNameTX = custNameTX;
		this.email = email;
		this.tradingName = tradingName;
		this.ctcName = ctcName;
		this.phoneNum = phoneNum;
	}

	public String getCustNameTX() {
		return custNameTX;
	}

	public void setCustNameTX(String custNameTX) {
		this.custNameTX = custNameTX;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getCtcName() {
		return ctcName;
	}

	public void setCtcName(String ctcName) {
		this.ctcName = ctcName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Form [custNameTX=" + custNameTX + ", email=" + email + ", tradingName=" + tradingName + ", ctcName=" + ctcName + ", phoneNum=" + phoneNum + "]";
	}
}
