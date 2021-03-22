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

public class ProductInstanceDAO extends GenericDAO<ProductInstance> {
    public ProductInstanceDAO() {
        super(ProductInstance.class);
    }

    public List<ProductInstance> findAllMatching(Product product, Double amountLo, Double amountHi, Date arrivalLo, Date arrivalHi,
            Date expiresLo, Date expiresHi, Integer roomNo, Integer shelfNo, Supply source, Order destination) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<ProductInstance> query = session.getCriteriaBuilder().createQuery(ProductInstance.class);
        Root<ProductInstance> root = query.from(ProductInstance.class);

        Expression<Boolean> restr = null;

        if (product != null) {
            Expression<Boolean> n = builder.equal(root.get(ProductInstance_.product), product);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(ProductInstance_.amount), amountLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(ProductInstance_.amount), amountHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (arrivalLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(ProductInstance_.arrival), arrivalLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (arrivalHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(ProductInstance_.arrival), arrivalHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (expiresLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(ProductInstance_.expires), expiresLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (expiresHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(ProductInstance_.expires), expiresHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (roomNo != null) {
            Expression<Boolean> n = builder.equal(root.get(ProductInstance_.roomNo), roomNo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (shelfNo != null) {
            Expression<Boolean> n = builder.equal(root.get(ProductInstance_.shelfNo), shelfNo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (source != null) {
            Expression<Boolean> n = builder.equal(root.get(ProductInstance_.source), source);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (destination != null) {
            Expression<Boolean> n = builder.equal(root.get(ProductInstance_.destination), destination);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<ProductInstance> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
