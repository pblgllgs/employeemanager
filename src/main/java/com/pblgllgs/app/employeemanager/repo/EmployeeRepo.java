package com.pblgllgs.app.employeemanager.repo;

import com.pblgllgs.app.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional findEmployeeById(Long id);
}
