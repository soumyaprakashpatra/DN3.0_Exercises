package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query methods
    Department findByName(String name);

    List<Department> findByNameContaining(String substring);

    // Custom query using @Query annotation
    @Query("SELECT d FROM Department d WHERE d.name LIKE %:nameFragment%")
    List<Department> findDepartmentsWithNameLike(String nameFragment);

    // Execute named queries
    List<Department> findByManagerName(String managerName);
}
