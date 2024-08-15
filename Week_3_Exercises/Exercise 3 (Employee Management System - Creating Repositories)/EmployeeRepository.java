package com.example.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.Model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    Employee findByEmail(String email);
}