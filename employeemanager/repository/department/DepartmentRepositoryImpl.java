package com.example.employeemanager.repository.department;

import com.example.employeemanager.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final SessionFactory sessionFactory;

    public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Department", Department.class).list();
        }
    }

    @Override
    public Department findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, id);
        }
    }

    @Override
    public void save(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void update(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            if (department != null) {
                session.delete(department);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Department> findByEmployeeId(int employeeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select d from Department d join d.employees e where e.id = :employeeId", Department.class)
                    .setParameter("employeeId", employeeId)
                    .list();
        }
    }
}