package com.vladimirpandurov.managerApp3.service;

import com.vladimirpandurov.managerApp3.domain.Employee;
import com.vladimirpandurov.managerApp3.exception.UserNotFoundException;
import com.vladimirpandurov.managerApp3.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        this.employeeRepository.deleteEmployeesById(id);
    }

    public Employee getEmployeeById(Long id){
        return this.employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Employee> getAll(){
        return this.employeeRepository.findAll();
    }


}
