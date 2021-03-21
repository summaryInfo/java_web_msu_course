package org.jbes.storage.dao;

import org.jbes.storage.entity.Provider;
import org.jbes.storage.entity.Provider_;
import org.jbes.storage.HibernateInitiallizationManager;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProviderDAO extends GenericDAO<Provider> {
    ProviderDAO() {
        super(Provider.class);
    }

    List<Provider> findAllMatching(String name, String description, String address, String tel, String email) {
        CriteriaBuilder builder = HibernateInitiallizationManager.getSessionFactory().getCriteriaBuilder();
        Session session = HibernateInitiallizationManager.createSession();
        CriteriaQuery<Provider> query = session.getCriteriaBuilder().createQuery(Provider.class);
        Root<Provider> root = query.from(Provider.class);

        if (name != null) {
            query = query.where(builder.like(root.get(Provider_.name), name));
        }
        if (description != null) {
            query = query.where(builder.like(root.get(Provider_.description), description));
        }
        if (address != null) {
            query = query.where(builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.address),
                    builder.literal(address)));
        }
        if (tel != null) {
            query = query.where(
                    builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.tel), builder.literal(tel)));
        }
        if (email != null) {
            query = query.where(
                    builder.function("arrayAnyLike", Boolean.class, root.get(Provider_.email), builder.literal(email)));
        }

        List<Provider> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
