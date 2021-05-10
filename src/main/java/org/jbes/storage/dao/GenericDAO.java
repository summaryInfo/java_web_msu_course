package org.jbes.storage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDAO<T> {
    private Class<T> thisClass;
    protected SessionFactory factory;
    
    protected GenericDAO(SessionFactory factory, Class<T> thisClass) {
        this.thisClass = thisClass;
        this.factory = factory;
    }

    public Long save(T entity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Long res = (Long)session.save(entity);
        tx.commit();
        session.close();
        return res;
    }

    public void update(T entity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public void saveOrUpdate(T entity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(entity);
        tx.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    public T findById(Long id) {
        Session session = factory.openSession();
        T entity = session.get(thisClass, id);
        session.close();
        return entity;
    }
}
