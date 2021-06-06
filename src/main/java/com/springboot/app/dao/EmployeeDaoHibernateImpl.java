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
    @Transactional
    public List<Employee> findAll() {
        return entityManager.unwrap(Session.class)
                        .createQuery("from Employee", Employee.class)
                        .getResultList();
    }
}
