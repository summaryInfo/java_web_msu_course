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

@Component
public class ProductCategoryDAO extends GenericDAO<ProductCategory> {
    public ProductCategoryDAO(SessionFactory factory) {
        super(factory, ProductCategory.class);
    }

    public List<ProductCategory> findAllMatching(String name, String description) {
        CriteriaBuilder builder = factory.getCriteriaBuilder();
        Session session = factory.openSession();
        CriteriaQuery<ProductCategory> query = builder.createQuery(ProductCategory.class);
        Root<ProductCategory> root = query.from(ProductCategory.class);

        Expression<Boolean> restr = null;

        if (name != null) {
            Expression<Boolean> n = builder.like(root.get(ProductCategory_.name), name);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (description != null) {
            Expression<Boolean> n = builder.like(root.get(ProductCategory_.description), description);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<ProductCategory> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
