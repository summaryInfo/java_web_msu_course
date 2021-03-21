package org.jbes.storage.dao;

import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jbes.storage.HibernateInitiallizationManager;

public class GenericDAO<T> {
    private Class<T> thisClass;

    GenericDAO(Class<T> thisClass) {
        this.thisClass = thisClass;
    }

    public void save(T entity) {
        Session session = HibernateInitiallizationManager.createSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateInitiallizationManager.createSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateInitiallizationManager.createSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    public T findById(Long id) {
        Session session = HibernateInitiallizationManager.createSession();
        T entity = session.get(thisClass, id); 
        session.close();
        return entity;
    }
}
