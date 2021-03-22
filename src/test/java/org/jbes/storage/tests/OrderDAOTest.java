package org.jbes.storage.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class OrderDAOTest {
    OrderDAO dao;
    ProductDAO productDao;
    ConsumerDAO consumerDao;
    List<Order> plist;

    @BeforeClass
    public void init() throws ParseException {
        dao = new OrderDAO();
        productDao = new ProductDAO();
        consumerDao = new ConsumerDAO();

        plist = new ArrayList<Order>();
        Consumer cons = consumerDao.findById(101L);
        Product p1 = productDao.findById(101L);
        Product p6 = productDao.findById(106L);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        plist.add(new Order(101L, cons, p1, 30., fmt.parse("2020-01-20"), true));
        plist.add(new Order(102L, cons, p1, 30., fmt.parse("2020-05-20"), false));
        plist.add(new Order(103L, cons, p1, 40., fmt.parse("2020-05-21"), false));
        plist.add(new Order(104L, cons, p6, 1., fmt.parse("2020-07-01"), false));
    }

    @Test
    public void testFindAllMatching1() {
        List<Order> results = dao.findAllMatching(null, null, null, null, null, null, null);

        System.out.println("Got orders:");
        for (Order cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected orders:");

        for (Order exp : plist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), plist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<Order> results = dao.findAllMatching(plist.get(0).getConsumer(), plist.get(0).getProduct(), 20., 30.,
                plist.get(0).getTime(), plist.get(0).getTime(), true);

        System.out.println("Got orders:");
        for (Order cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected orders:");

        System.out.println(plist.get(0));
        Assert.assertEquals(results.contains(plist.get(0)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching3() {
        List<Order> results = dao.findAllMatching(null, null, 200., 300., null, null, true);
        Assert.assertEquals(results.size(), 0, "Non-matching results returned");
    }
}
