package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
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

        Expression<Boolean> restr = null;

        if (consumer != null) {
            Expression<Boolean> n = builder.equal(root.get(Order_.consumer), consumer);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (product != null) {
            Expression<Boolean> n = builder.equal(root.get(Order_.product), product);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(Order_.amount), amountLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(Order_.amount), amountHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (timeLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(Order_.time), timeLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (timeHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(Order_.time), timeHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (completed != null) {
            Expression<Boolean> n = builder.equal(root.get(Order_.completed), completed);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<Order> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
