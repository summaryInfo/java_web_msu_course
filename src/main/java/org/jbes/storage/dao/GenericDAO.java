package org.jbes.storage.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
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
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    public T findById(Long id) {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        T entity = session.get(thisClass, id); 
        session.close();
        return entity;
    }

    public List<T> findAll() {
        Session session = HibernateInitiallizationManager.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(thisClass);
        Root<T> rootEntry = cq.from(thisClass);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        session.close();
        return allQuery.getResultList();
    }
}
