package org.jbes.storage;

import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbes.storage.entity.*;

public class HibernateInitiallizationManager {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Consumer.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(ProductCategory.class);
                configuration.addAnnotatedClass(ProductInstance.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Provider.class);
                configuration.addAnnotatedClass(Supply.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Unable to create session factory: " + e);
            }
        }
        return sessionFactory;
    }

    public static Session createSession() {
        return getSessionFactory().openSession();
    }

    public static CriteriaBuilder getCriteriaBuilder() {
        return getSessionFactory().getCriteriaBuilder();
    }
}
