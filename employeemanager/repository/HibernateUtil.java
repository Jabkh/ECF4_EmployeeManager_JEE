package com.example.employeemanager.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

    private static SessionFactory factory;

    private HibernateUtil() {}

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        }
        return factory;
    }

}