package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.Dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    Employee findByEmail(String email);

    List<Employee> findByName(String name);

    // Pagination and Sorting using Page and Pageable
    Page<Employee> findAll(Pageable pageable);

    // Custom query with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    Page<Employee> findEmployeesByDepartmentName(String departmentName, Pageable pageable);

    // Example of a custom method with sorting
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findEmployeesByNameContaining(String name, Pageable pageable);

    // Named query example with pagination
    @Query(name = "Employee.findAllOrderedByEmail")
    Page<Employee> findAllEmployeesOrderedByEmail(Pageable pageable);

    // Interface-based projection
    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, e.department.name AS departmentName " +
           "FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeProjection> findEmployeeProjectionsByDepartmentName(String departmentName);

    // Class-based projection (DTO)
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) " +
           "FROM Employee e")
    List<EmployeeDto> findAllEmployeeDTOs();
}
