package com.jsp.SmartEnrollmentSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.SmartEnrollmentSystem.Model.Employee;
import com.jsp.SmartEnrollmentSystem.Service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	EmployeeService employeeService;
	
	 // Dashboard Page (Landing Page)
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";  // Static landing page (with login/register buttons)
    }

    // Show Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Show Register Page (Admin can access this)
    @GetMapping("/register")
    public String registerPage(Model model, HttpSession session) {
        // Optional: Add check if only admin can register
        model.addAttribute("employee", new Employee());
        return "register";
    }

    //  Register Logic (Call Service)
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("employee") Employee employee,
                           BindingResult result,
                           Model model,
                           HttpSession session) {
        return employeeService.registerEmployee(employee, result, model, session);
    }

    // 5️⃣ Login Logic (Call Service)
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        return employeeService.loginUser(email, password, model, session);
    }

    // 6️⃣ Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/dashboard";
    }

}
