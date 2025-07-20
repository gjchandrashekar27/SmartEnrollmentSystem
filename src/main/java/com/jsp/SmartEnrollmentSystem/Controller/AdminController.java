package com.jsp.SmartEnrollmentSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.SmartEnrollmentSystem.Repository.EmployeeRepository;



@Controller
public class AdminController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	 @GetMapping("/admin/dashboard")
	    public String showAdminDashboard() {
	        return "admin-dashboard"; // should match the Thymeleaf HTML file name
	    }
	 
	 @GetMapping("/admin/employees")
	 public String viewAllEmployees(Model model) {
	     model.addAttribute("employees", employeeRepository.findAll());
	     return "employee-list";
	 }


}
