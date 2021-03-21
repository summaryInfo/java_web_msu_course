package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Date;

public class OrderDAO extends GenericDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }

    public List<Order> findAllMatching(Consumer consumer, Product product, Double amountLo, Double amountHi, Date timeLo,
            Date timeHi, Boolean completed) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Order> query = session.getCriteriaBuilder().createQuery(Order.class);
        Root<Order> root = query.from(Order.class);

        if (consumer != null) {
            query = query.where(builder.equal(root.get(Order_.consumer), consumer));
        }
        if (product != null) {
            query = query.where(builder.equal(root.get(Order_.product), product));
        }
        if (amountLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(Order_.amount), amountLo));
        }
        if (amountHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(Order_.amount), amountHi));
        }
        if (timeLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(Order_.time), timeLo));
        }
        if (timeHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(Order_.time), timeHi));
        }
        if (completed != null) {
            query = query.where(builder.equal(root.get(Order_.completed), completed));
        }

        List<Order> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
