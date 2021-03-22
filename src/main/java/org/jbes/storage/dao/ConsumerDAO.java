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
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.address),
                    builder.literal(address)), true);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (tel != null) {
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.tel),
                    builder.literal(tel)), true);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (email != null) {
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Consumer_.email),
                    builder.literal(email)), true);
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
