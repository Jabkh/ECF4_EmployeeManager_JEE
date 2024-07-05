package com.example.employeemanager.repository.job;

import com.example.employeemanager.model.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class JobRepositoryImpl implements JobRepository {

    private final SessionFactory sessionFactory;

    public JobRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Job> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Job", Job.class).list();
        }
    }

    @Override
    public Job findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Job.class, id);
        }
    }

    @Override
    public void save(Job job) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(job);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void update(Job job) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(job);
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
            Job job = session.get(Job.class, id);
            if (job != null) {
                session.delete(job);
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
    public List<Job> findByEmployeeId(int employeeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Job where employee.id = :employeeId", Job.class)
                    .setParameter("employeeId", employeeId)
                    .list();
        }
    }
}