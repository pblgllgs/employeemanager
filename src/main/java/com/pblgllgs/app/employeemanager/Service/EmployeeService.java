package com.pblgllgs.app.employeemanager.Service;

import com.pblgllgs.app.employeemanager.exception.UserNotFoundException;
import com.pblgllgs.app.employeemanager.model.Employee;
import com.pblgllgs.app.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Transactional
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    @Transactional(readOnly = true)
    public List <Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeById(Long id){
       return employeeRepo.findEmployeeById(id).orElseThrow(
               () -> new UserNotFoundException("USUARIO by id " + id + "no fue encontrado"));
    }
    @Transactional
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
