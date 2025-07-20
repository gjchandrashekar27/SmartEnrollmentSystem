package com.jsp.SmartEnrollmentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SmartEnrollmentSystem.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Object findByEmail(String email);

	Employee findByEmailAndPassword(String email, String password);

}
