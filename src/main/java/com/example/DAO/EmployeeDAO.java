package com.example.DAO;

import com.example.pojo.Employee;
import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
}
