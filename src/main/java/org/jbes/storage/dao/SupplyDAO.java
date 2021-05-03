package org.jbes.storage.dao;

import org.springframework.stereotype.Component;
import org.jbes.storage.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
import java.util.List;
import java.util.Date;

@Component
public class SupplyDAO extends GenericDAO<Supply> {
    public SupplyDAO(SessionFactory factory) {
        super(factory, Supply.class);
    }

    public List<Supply> findAllMatching(Provider provider, Product product, Double amountLo, Double amountHi, Date timeLo,
            Date timeHi, Boolean completed) {
        CriteriaBuilder builder = factory.getCriteriaBuilder();
        Session session = factory.openSession();
        CriteriaQuery<Supply> query = builder.createQuery(Supply.class);
        Root<Supply> root = query.from(Supply.class);

        Expression<Boolean> restr = null;

        if (provider != null) {
            Expression<Boolean> n = builder.equal(root.get(Supply_.provider), provider);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (product != null) {
            Expression<Boolean> n = builder.equal(root.get(Supply_.product), product);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(Supply_.amount), amountLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (amountHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(Supply_.amount), amountHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (timeLo != null) {
            Expression<Boolean> n = builder.greaterThanOrEqualTo(root.get(Supply_.time), timeLo);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (timeHi != null) {
            Expression<Boolean> n = builder.lessThanOrEqualTo(root.get(Supply_.time), timeHi);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (completed != null) {
            Expression<Boolean> n = builder.equal(root.get(Supply_.completed), completed);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<Supply> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
