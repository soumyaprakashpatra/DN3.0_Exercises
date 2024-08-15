package com.example.EmployeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeeManagementSystem.Model.Employee;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Read an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Read all employees with pagination and sorting
    @GetMapping
    public ResponseEntity<Page<Employee>> getAllEmployees(
            @PageableDefault(sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employee.setId(id);
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    // Read employees by department with pagination and sorting
    @GetMapping("/department")
    public ResponseEntity<Page<Employee>> getEmployeesByDepartmentName(
            @RequestParam String departmentName,
            @PageableDefault(sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = employeeRepository.findEmployeesByDepartmentName(departmentName, pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Search employees by name with pagination and sorting
   // Get paginated and sorted employees
   @GetMapping("/search")
   public Page<Employee> getPaginatedAndSortedEmployees(
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "10") int size,
           @RequestParam(defaultValue = "name") String sortBy) {
       return employeeService.getPaginatedAndSortedEmployees(page, size, sortBy);
   }
}
