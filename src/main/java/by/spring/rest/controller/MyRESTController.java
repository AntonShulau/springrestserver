package by.spring.rest.controller;

import by.spring.rest.entity.Employee;
import by.spring.rest.exception_handing.EmployeeIncorrectData;
import by.spring.rest.exception_handing.NoSuchEmployeeException;
import by.spring.rest.service.EmployeeService;
import by.spring.rest.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmloyees=employeeService.getAllEmployees();
        return allEmloyees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee=employeeService.getEmployeeById(id);
        if(employee==null){
            throw new NoSuchEmployeeException("There is no employee with "+id+" in Database.");
        }
        return employee;
    }



}
