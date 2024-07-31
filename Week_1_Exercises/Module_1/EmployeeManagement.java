import java.util.Arrays;


class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null; // Remove last reference
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        EmployeeManagement empMgmt = new EmployeeManagement(5);

        empMgmt.addEmployee(new Employee("E001", "Alice", "Manager", 75000));
        empMgmt.addEmployee(new Employee("E002", "Bob", "Developer", 60000));
        empMgmt.addEmployee(new Employee("E003", "Charlie", "Designer", 55000));

        System.out.println("All Employees:");
        empMgmt.traverseEmployees();

        System.out.println("\nSearching for employee E002:");
        Employee emp = empMgmt.searchEmployee("E002");
        System.out.println(emp);

        System.out.println("\nDeleting employee E001:");
        empMgmt.deleteEmployee("E001");

        System.out.println("\nAll Employees after deletion:");
        empMgmt.traverseEmployees();
    }
}

    // Step 4: Analysis
    // Time Complexity:
    // - Add Employee: O(1) - Directly adds to the end if space is available.
    // - Search Employee: O(n) - Linear search through the array.
    // - Traverse Employees: O(n) - Visits each element once.
    // - Delete Employee: O(n) - Linear search to find the element, followed by shifting elements.

    // Limitations of Arrays:
    // - Fixed Size: The size of an array is static, meaning it can't be resized dynamically.
    // - Inefficient Operations: Insertion and deletion can be inefficient as they may require shifting elements.

    // When to Use Arrays:
    // - Small, Fixed-Size Datasets: Arrays work well when the number of elements is known and not too large.
    // - Simple Implementation: Useful for straightforward applications where complex dynamic resizing isn't needed