package org.jbes.storage.dao;

import org.jbes.storage.entity.*;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
import java.util.List;

public class ProviderDAO extends GenericDAO<Provider> {
    public ProviderDAO() {
        super(Provider.class);
    }

    public List<Provider> findAllMatching(String name, String description, String address, String tel, String email) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Provider> query = session.getCriteriaBuilder().createQuery(Provider.class);
        Root<Provider> root = query.from(Provider.class);

        Expression<Boolean> restr = null;

        if (name != null) {
            Expression<Boolean> n =builder.like(root.get(Provider_.name), name);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (description != null) {
            Expression<Boolean> n =builder.like(root.get(Provider_.description), description);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (address != null) {
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.address),
                    builder.literal(address)), true);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (tel != null) {
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.tel),
                    builder.literal(tel)), true);
            restr = restr != null ? builder.and(restr, n) : n;
        }
        if (email != null) {
            Expression<Boolean> n = builder.equal(builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.email),
                    builder.literal(email)), true);
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
