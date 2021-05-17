package org.jbes.storage.dao;

import org.springframework.stereotype.Component;
import org.jbes.storage.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.*;
import java.util.List;

@Component
public class ConsumerDAO extends GenericDAO<Consumer> {
    public ConsumerDAO(SessionFactory factory) {
        super(factory, Consumer.class);
    }

    public List<Consumer> findAllMatching(String name, String description, String address, String phone, String email) {
        CriteriaBuilder builder = factory.getCriteriaBuilder();
        Session session = factory.openSession();
        CriteriaQuery<Consumer> query = builder.createQuery(Consumer.class);
        Root<Consumer> root = query.from(Consumer.class);

        Expression<Boolean> restr = null;

        if (name != null) {
            Expression<Boolean> n = builder.like(root.get(Consumer_.name), name);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (description != null) {
            Expression<Boolean> n = builder.like(root.get(Consumer_.description), description);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (address != null) {
            Expression<Boolean> n = builder.like(root.get(Consumer_.address), address);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (phone != null) {
            Expression<Boolean> n = builder.like(root.get(Consumer_.phone), phone);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (email != null) {
            Expression<Boolean> n = builder.like(root.get(Consumer_.email), email);
            restr = restr != null ? builder.and(restr, n) : n;
        }

        if (restr != null) {
            query = query.where(restr);
        }

        List<Consumer> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
