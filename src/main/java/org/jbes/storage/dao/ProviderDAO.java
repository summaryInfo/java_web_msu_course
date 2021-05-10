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
public class ProviderDAO extends GenericDAO<Provider> {
    public ProviderDAO(SessionFactory factory) {
        super(factory, Provider.class);
    }

    public List<Provider> findAllMatching(String name, String description, String address, String tel, String email) {
        CriteriaBuilder builder = factory.getCriteriaBuilder();
        Session session = factory.openSession();
        CriteriaQuery<Provider> query = builder.createQuery(Provider.class);
        Root<Provider> root = query.from(Provider.class);

        Expression<Boolean> restr = null;

        if (name != null) {
            Expression<Boolean> n = builder.like(root.get(Provider_.name), name);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (description != null) {
            Expression<Boolean> n = builder.like(root.get(Provider_.description), description);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (address != null) {
            Expression<Boolean> n = builder.like(root.get(Provider_.address), address);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (tel != null) {
            Expression<Boolean> n = builder.like(root.get(Provider_.tel), tel);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (email != null) {
            Expression<Boolean> n = builder.like(root.get(Provider_.email), email);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<Provider> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
