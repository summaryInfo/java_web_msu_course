package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductCategoryDAO extends GenericDAO<ProductCategory> {
    public ProductCategoryDAO() {
        super(ProductCategory.class);
    }

    public List<ProductCategory> findAllMatching(String name, String description) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<ProductCategory> query = session.getCriteriaBuilder().createQuery(ProductCategory.class);
        Root<ProductCategory> root = query.from(ProductCategory.class);

        if (name != null) {
            query = query.where(builder.like(root.get(ProductCategory_.name), name));
        }
        if (description != null) {
            query = query.where(builder.like(root.get(ProductCategory_.description), description));
        }

        List<ProductCategory> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
