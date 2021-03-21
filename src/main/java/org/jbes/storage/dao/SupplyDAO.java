package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Date;

public class SupplyDAO extends GenericDAO<Supply> {
    public SupplyDAO() {
        super(Supply.class);
    }

    public List<Supply> findAllMatching(Provider provider, Product product, Double amountLo, Double amountHi, Date timeLo,
            Date timeHi, Boolean completed) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Supply> query = session.getCriteriaBuilder().createQuery(Supply.class);
        Root<Supply> root = query.from(Supply.class);

        if (provider != null) {
            query = query.where(builder.equal(root.get(Supply_.provider), provider));
        }
        if (product != null) {
            query = query.where(builder.equal(root.get(Supply_.product), product));
        }
        if (amountLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(Supply_.amount), amountLo));
        }
        if (amountHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(Supply_.amount), amountHi));
        }
        if (timeLo != null) {
            query = query.where(builder.greaterThanOrEqualTo(root.get(Supply_.time), timeLo));
        }
        if (timeHi != null) {
            query = query.where(builder.lessThanOrEqualTo(root.get(Supply_.time), timeHi));
        }
        if (completed != null) {
            query = query.where(builder.equal(root.get(Supply_.completed), completed));
        }

        List<Supply> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
