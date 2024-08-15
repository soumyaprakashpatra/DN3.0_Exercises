package com.example.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.Model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query methods
    Department findByName(String name);
}