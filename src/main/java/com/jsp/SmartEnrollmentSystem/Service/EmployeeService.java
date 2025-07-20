package com.jsp.SmartEnrollmentSystem.Service;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jsp.SmartEnrollmentSystem.Model.Employee;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

public interface EmployeeService {

	String registerEmployee(@Valid Employee employee, BindingResult result, Model model, HttpSession session);

	String loginUser(String email, String password, Model model, HttpSession session);

	void updateEmployee(Employee updatedEmployee);

}
