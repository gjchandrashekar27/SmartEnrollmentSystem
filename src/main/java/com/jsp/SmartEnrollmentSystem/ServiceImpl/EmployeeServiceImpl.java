package com.jsp.SmartEnrollmentSystem.ServiceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jsp.SmartEnrollmentSystem.Model.Employee;
import com.jsp.SmartEnrollmentSystem.Repository.EmployeeRepository;
import com.jsp.SmartEnrollmentSystem.Service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String registerEmployee(@Valid Employee employee, BindingResult result, Model model, HttpSession session) {
		 if (result.hasErrors()) {
	            return "register"; // return to form if validation fails
	        }

	        // Optional: check if email already exists
	        if (employeeRepository.findByEmail(employee.getEmail()) != null) {
	            model.addAttribute("error", "Email already registered");
	            return "register";
	        }

	        employeeRepository.save(employee); // save new employee
	        model.addAttribute("success", "Employee registered successfully");
	        return "redirect:/login";
	}
	
	@Override
	public String loginUser(String email, String password, Model model, HttpSession session) {
	    Employee employee = employeeRepository.findByEmailAndPassword(email, password);

	    if (employee != null) {
	        session.setAttribute("employee", employee); // Store logged-in employee object

	        // Redirect based on role
	        if ("Admin".equalsIgnoreCase(employee.getRole())) {
	            return "redirect:/admin/dashboard";
	        } else {
	            return "redirect:/employee/dashboard";
	        }
	    } else {
	        model.addAttribute("error", "Invalid email or password");
	        return "login"; // Back to login page on failure
	    }
	}

	@Override
	public void updateEmployee(Employee updatedEmployee) {
		 // Optional: fetch the existing record to ensure update happens only if present
	    Optional<Employee> optionalEmployee = employeeRepository.findById(updatedEmployee.getId());

	    if (optionalEmployee.isPresent()) {
	        Employee existing = optionalEmployee.get();

	        // Update fields
	        existing.setFirstName(updatedEmployee.getFirstName());
	        existing.setMiddleName(updatedEmployee.getMiddleName());
	        existing.setLastName(updatedEmployee.getLastName());
	        existing.setDob(updatedEmployee.getDob());
	        existing.setGender(updatedEmployee.getGender());
	        existing.setPhone(updatedEmployee.getPhone());
	        existing.setEmail(updatedEmployee.getEmail());
	        existing.setPassword(updatedEmployee.getPassword());
	        existing.setDesignation(updatedEmployee.getDesignation());
	        existing.setRole(updatedEmployee.getRole());

	        // Save updated entity
	        employeeRepository.save(existing);
	    }
		
	}



	}


