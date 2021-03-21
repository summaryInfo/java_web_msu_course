package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Date;

public class ProductInstanceDAO extends GenericDAO<ProductInstance> {
    ProductInstanceDAO() {
        super(ProductInstance.class);
    }

    List<ProductInstance> findAllMatching(Product product, Double amountLo, Double amountHi, Date arrivalLo, Date arrivalHi,
            Date expiresLo, Date expiresHi, Integer roomNo, Integer shelfNo, Supply source, Order destination) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<ProductInstance> query = session.getCriteriaBuilder().createQuery(ProductInstance.class);
        Root<ProductInstance> root = query.from(ProductInstance.class);

        if (product != null) {
            query = query.where(builder.equal(root.get(ProductInstance_.product), product));
        }
        if (amountLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(ProductInstance_.amount), amountLo));
        }
        if (amountHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(ProductInstance_.amount), amountHi));
        }
        if (arrivalLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(ProductInstance_.arrival), arrivalLo));
        }
        if (arrivalHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(ProductInstance_.arrival), arrivalHi));
        }
        if (expiresLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(ProductInstance_.expires), expiresLo));
        }
        if (expiresHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(ProductInstance_.expires), expiresHi));
        }
        if (roomNo != null) {
            query = query.where(builder.equal(root.get(ProductInstance_.roomNo), roomNo));
        }
        if (shelfNo != null) {
            query = query.where(builder.equal(root.get(ProductInstance_.shelfNo), shelfNo));
        }
        if (source != null) {
            query = query.where(builder.equal(root.get(ProductInstance_.source), source));
        }
        if (destination != null) {
            query = query.where(builder.equal(root.get(ProductInstance_.destination), destination));
        }

        List<ProductInstance> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
