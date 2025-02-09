/**
 * 
 * I declare that this code was written by me, 22013446. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Ashley Teo
 * Student ID: 22013445
 * Class: E63C
 * Date created: 2025-Jan-18 10:09:41 pm 
 * 
 */

package FYPproject;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Singpass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	 @Column(name = "username", nullable = false)
	    private String username = ""; // Default to an empty string

    @Column(name = "password", nullable = false)
    private String password = "";

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(name = "education", nullable = false)
    private String education;
	

	private String role;
	
	@NotNull(message="NRIC cannot be empty!")
	@NotEmpty(message="NRIC cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String nric;
	private String enteredNRIC;
	
	
	@NotNull(message="Name cannot be empty!")
	@NotEmpty(message="Name cannot be empty!")
	@Size(min=5, max=50, message="Name length must be between 1 and 50 characters!")
	private String name;
	
	@NotNull(message="Gender cannot be empty!")
	@NotEmpty(message="Gender cannot be empty!")
	@Size(min=5, max=50, message="Gender length must be between 4 and 7 characters!")
	private String gender;
	
	@NotNull(message="Race cannot be empty!")
	@NotEmpty(message="Race cannot be empty!")
	@Size(min=5, max=100, message="Race length must be between 1 and 10 characters!")
	private String race;
	
	@NotNull(message="Nationality cannot be empty!")
	@NotEmpty(message="Race cannot be empty!")
	@Size(min=5, max=100, message="Nationality length must be between 1 and 50 characters!")
	private String nationality;
	

	private String housingType;

	@NotNull(message="HDB cannot be empty!")
	@NotEmpty(message="HDB cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String hdbType;
	
	
	@NotNull(message="PropertyStatus cannot be empty!")
	@NotEmpty(message="PropertyStatus cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String propertyStatus;
	
	@NotNull(message="CPF cannot be empty!")
	@NotEmpty(message="CPF cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String cpfOABalance;
	
	@NotNull(message="CPF cannot be empty!")
	@NotEmpty(message="CPF cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String cpfMABalance;
	
	@NotNull(message="CPF cannot be empty!")
	@NotEmpty(message="CPF cannot be empty!")
	@Size(min=5, max=100, message="length must be between 1 and 50 characters!")
	private String cpfSABalance;
	
	@NotNull(message="email cannot be empty!")
	@NotEmpty(message="email cannot be empty!")
	@Size(min=5, max=100, message="email must be between 1 and 50 characters!")
	private String email;
	
	
	
	@NotNull(message="phone number cannot be empty!")
	@NotEmpty(message="phone number cannot be empty!")
	private String phoneNumber;

	@NotNull(message="date of birth cannot be empty!")
	@NotEmpty(message="date of birth cannot be empty!")
	private String dateOfBirth;
	
	@NotNull(message = "Income cannot be empty!")
	@NotEmpty(message ="Income cannot be empty!")
	private String income;
	
	
	@NotNull(message = "OTP cannot be empty!")
	@NotEmpty(message ="OTP cannot be empty!")
	private String otp;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public String getEnteredNRIC() {
		return enteredNRIC;
	}
	public void setEnteredNRIC(String enteredNRIC) {
		this.enteredNRIC = enteredNRIC;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHousingType() {
		return housingType;
	}

	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	public String getHdbType() {
		return hdbType;
	}

	public void setHdbType(String hdbType) {
		this.hdbType = hdbType;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getCpfOABalance() {
		return cpfOABalance;
	}

	public void setCpfOABalance(String cpfOABalance) {
		this.cpfOABalance = cpfOABalance;
	}

	public String getCpfMABalance() {
		return cpfMABalance;
	}

	public void setCpfMABalance(String cpfMABalance) {
		this.cpfMABalance = cpfMABalance;
	}

	public String getCpfSABalance() {
		return cpfSABalance;
	}

	public void setCpfSABalance(String cpfSABalance) {
		this.cpfSABalance = cpfSABalance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

}
