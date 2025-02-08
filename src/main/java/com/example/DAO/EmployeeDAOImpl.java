package com.example.DAO;
import com.example.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory factory;
    public EmployeeDAOImpl() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }
    @Override
    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Employee emp = session.get(Employee.class, id);
        session.close();
        return emp;
    }
    @Override
    public List<Employee> getAllEmployees() {
        Session session = factory.openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return employees;
    }
    @Override
    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
        }
        tx.commit();
        session.close();
    }
}
