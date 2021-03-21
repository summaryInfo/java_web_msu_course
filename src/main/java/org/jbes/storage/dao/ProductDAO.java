package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        if (name != null) {
            query = query.where(builder.like(root.get(Product_.name), name));
        }
        if (description != null) {
            query = query.where(builder.like(root.get(Product_.description), description));
        }
        if (category != null) {
            query = query.where(builder.equal(root.get(Product_.category), category));
        }
        if (unit != null) {
            query = query.where(builder.like(root.get(Product_.unit), unit));
        }
        if (oversized != null) {
            query = query.where(builder.equal(root.get(Product_.oversized), oversized));
        }

        List<Product> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
