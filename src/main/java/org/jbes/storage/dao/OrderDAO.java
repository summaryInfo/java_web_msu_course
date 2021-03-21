package org.jbes.storage.dao;

import org.jbes.storage.entity.*;

public class OrderDAO extends GenericDAO<Order> {
    OrderDAO() {
        super(Order.class);
    }
}
