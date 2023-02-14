package com.vladimirpandurov.managerApp3.repository;

import com.vladimirpandurov.managerApp3.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeesById(Long id);

    Optional<Employee> findEmployeeById(Long id);

}
