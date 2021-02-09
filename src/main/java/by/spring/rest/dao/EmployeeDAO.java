package by.spring.rest.dao;

import by.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

//    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public Employee getEmployeeById(int id);
}
