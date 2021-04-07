package by.spring.rest.dao;

import by.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();
        Query<Employee> query=session.createQuery("from Employee ", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;

    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(employee);
    }

    public Employee getEmployeeById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Employee query=session.get(Employee.class,id);
        return query;

    }

}
