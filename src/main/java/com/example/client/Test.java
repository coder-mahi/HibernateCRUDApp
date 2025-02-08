package com.example.client;

import com.example.DAO.EmployeeDAO;
import com.example.DAO.EmployeeDAOImpl;
import com.example.pojo.Address;
import com.example.pojo.Employee;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Show All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); 

                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter Pincode: ");
                    int pincode = scanner.nextInt();
                    scanner.nextLine();
                    Address address = new Address(city, pincode);
                    Employee employee = new Employee(firstName, lastName, salary, address);

                    employeeDAO.saveEmployee(employee);
                    System.out.println("Employee saved successfully!");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to retrieve: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    Employee retrievedEmployee = employeeDAO.getEmployee(empId);
                    
                    if (retrievedEmployee != null) {
                        System.out.println("Retrieved Employee: " + retrievedEmployee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 3:
                    List<Employee> employees = employeeDAO.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        System.out.println("All Employees:");
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); 
                    employeeDAO.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
