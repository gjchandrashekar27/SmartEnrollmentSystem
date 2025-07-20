package com.jsp.SmartEnrollmentSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.SmartEnrollmentSystem.Model.Employee;
import com.jsp.SmartEnrollmentSystem.Service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee/dashboard")
	public String showEmployeeDashboard(HttpSession session, Model model) {
	    Employee employee = (Employee) session.getAttribute("employee");
	    
	    if (employee == null) {
	        return "redirect:/login";
	    }

	    model.addAttribute("employee", employee);
	    return "employee-dashboard";
	}
	
	@GetMapping("/employee/edit")
	public String editProfile(HttpSession session, Model model) {
	    Employee employee = (Employee) session.getAttribute("employee");
	    if (employee == null) return "redirect:/login";

	    model.addAttribute("employee", employee);
	    return "employee-edit";
	}
	
	@PostMapping("/employee/update")
	public String updateEmployee(@ModelAttribute("employee") Employee updatedEmployee, HttpSession session) {
	    Employee current = (Employee) session.getAttribute("employee");
	    updatedEmployee.setId(current.getId());
	    employeeService.updateEmployee(updatedEmployee);
	    session.setAttribute("employee", updatedEmployee); // Update session
	    return "redirect:/employee/dashboard";
	}




}
