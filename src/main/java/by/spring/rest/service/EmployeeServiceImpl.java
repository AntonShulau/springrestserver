package by.spring.rest.service;


import by.spring.rest.dao.EmployeeDAO;
import by.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl  implements  EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional //спринг сам контролирует открытие и закрытие транзакции
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

//    @Override
//    @Transactional
//    public void updateEmployee(Employee employee) {
//        employeeDAO.updateEmployee(employee);
//    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }


}
