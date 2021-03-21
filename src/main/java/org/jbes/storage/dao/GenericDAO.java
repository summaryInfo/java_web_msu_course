package org.jbes.storage.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jbes.storage.HibernateInitiallizationManager;

public class GenericDAO<T> {
    private Class<T> thisClass;

    GenericDAO(Class<T> thisClass) {
        this.thisClass = thisClass;
    }

    public void save(T entity) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public T findById(Long id) {
        return HibernateInitiallizationManager.getSessionFactory().openSession().get(thisClass, id);
    }
}
