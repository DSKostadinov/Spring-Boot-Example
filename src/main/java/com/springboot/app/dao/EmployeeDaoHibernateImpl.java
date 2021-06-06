package com.springboot.app.dao;

import com.springboot.app.persistence.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    private EntityManager entityManager;

    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.unwrap(Session.class)
                        .createQuery("from Employee", Employee.class)
                        .getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.unwrap(Session.class)
                .get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        entityManager.unwrap(Session.class)
                .saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        entityManager.unwrap(Session.class)
                .createQuery(
                        "delete from Employee where id=:employeeId"
                ).setParameter("employeeId", id)
                .executeUpdate();
    }
}
