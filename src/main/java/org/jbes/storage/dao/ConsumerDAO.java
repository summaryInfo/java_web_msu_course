package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.*;
import java.util.List;

public class ConsumerDAO extends GenericDAO<Consumer> {
    public ConsumerDAO() {
        super(Consumer.class);
    }

    public List<Consumer> findAllMatching(String name, String description, String address, String tel, String email) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Consumer> query = session.getCriteriaBuilder().createQuery(Consumer.class);
        Root<Consumer> root = query.from(Consumer.class);

        if (name != null) {
            query = query.where(builder.like(root.get(Consumer_.name), name));
        }
        if (description != null) {
            query = query.where(builder.like(root.get(Consumer_.description), description));
        }
        if (address != null) {
            query = query.where(builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.address),
                    builder.literal(address)));
        }
        if (tel != null) {
            query = query.where(
                    builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.tel), builder.literal(tel)));
        }
        if (email != null) {
            query = query.where(
                    builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.email), builder.literal(email)));
        }

        List<Consumer> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
