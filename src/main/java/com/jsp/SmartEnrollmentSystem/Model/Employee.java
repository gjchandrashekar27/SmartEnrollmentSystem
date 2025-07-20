package com.jsp.SmartEnrollmentSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "First name is required")
	    private String firstName;

	    private String middleName;

	    @NotBlank(message = "Last name is required")
	    private String lastName;

	    @NotNull(message = "Date of birth is required")
	    private String dob;

	    @NotBlank(message = "Gender is required")
	    private String gender;

	    @NotBlank(message = "Phone is required")
	    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
	    private String phone;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;

	    @NotBlank(message = "Designation is required")
	    private String designation;

	    @NotBlank(message = "Role is required")
	    private String role;


}
