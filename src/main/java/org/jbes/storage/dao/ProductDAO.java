package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
import java.util.List;

public class ProductDAO extends GenericDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }

    public List<Product> findAllMatching(String name, String description, ProductCategory category, String unit, Boolean oversized) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Product> query = session.getCriteriaBuilder().createQuery(Product.class);
        Root<Product> root = query.from(Product.class);

        Expression<Boolean> restr = null;

        if (name != null) {
            Expression<Boolean> n = builder.like(root.get(Product_.name), name);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (description != null) {
            Expression<Boolean> n = builder.like(root.get(Product_.description), description);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (category != null) {
            Expression<Boolean> n = builder.equal(root.get(Product_.category), category);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (unit != null) {
            Expression<Boolean> n = builder.like(root.get(Product_.unit), unit);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (oversized != null) {
            Expression<Boolean> n = builder.equal(root.get(Product_.oversized), oversized);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<Product> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
