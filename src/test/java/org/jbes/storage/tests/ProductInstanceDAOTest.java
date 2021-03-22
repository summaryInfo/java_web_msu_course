package org.jbes.storage.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductInstanceDAOTest {
    private ProductInstanceDAO dao;
    private OrderDAO orderDao;
    private SupplyDAO supplyDao;
    private ProductDAO productDao;
    private List<ProductInstance> plist;

    @BeforeClass
    public void init() throws ParseException {
        dao = new ProductInstanceDAO();
        orderDao = new OrderDAO();
        supplyDao = new SupplyDAO();
        plist = new ArrayList<ProductInstance>();
        plist.add(new ProductInstance());
        plist.add(new ProductInstance(1L, productDao.findById(1L), 10, DateFormat.getDateInstance().parse("2020-12-21"),
                DateFormat.getDateInstance().parse("2021-06-03"), 1, 1, supplyDao.findById(1L), orderDao.findById(2L)));
        plist.add(new ProductInstance(2L, productDao.findById(1L), 10, DateFormat.getDateInstance().parse("2020-12-21"),
                DateFormat.getDateInstance().parse("2021-06-03"), 1, 1, supplyDao.findById(1L), orderDao.findById(2L)));
        plist.add(new ProductInstance(3L, productDao.findById(1L), 10, DateFormat.getDateInstance().parse("2020-12-21"),
                DateFormat.getDateInstance().parse("2021-06-03"), 1, 2, supplyDao.findById(1L), orderDao.findById(2L)));
        plist.add(new ProductInstance(4L, productDao.findById(1L), 10, DateFormat.getDateInstance().parse("2020-12-21"),
                DateFormat.getDateInstance().parse("2021-06-03"), 1, 2, supplyDao.findById(1L), orderDao.findById(3L)));
        plist.add(new ProductInstance(5L, productDao.findById(1L), 15, DateFormat.getDateInstance().parse("2020-11-17"),
                DateFormat.getDateInstance().parse("2021-04-03"), 1, 3, supplyDao.findById(2L), orderDao.findById(3L)));
        plist.add(new ProductInstance(6L, productDao.findById(1L), 15, DateFormat.getDateInstance().parse("2020-11-17"),
                DateFormat.getDateInstance().parse("2021-04-03"), 1, 3, supplyDao.findById(2L), orderDao.findById(3L)));
        plist.add(new ProductInstance(7L, productDao.findById(1L), 15, DateFormat.getDateInstance().parse("2020-11-17"),
                DateFormat.getDateInstance().parse("2021-04-03"), 1, 3, supplyDao.findById(2L), null));
        plist.add(new ProductInstance(8L, productDao.findById(2L), 6, DateFormat.getDateInstance().parse("2021-01-13"),
                DateFormat.getDateInstance().parse("2021-03-13"), 1, 5, supplyDao.findById(3L), null));
        plist.add(new ProductInstance(9L, productDao.findById(2L), 6, DateFormat.getDateInstance().parse("2021-01-13"),
                DateFormat.getDateInstance().parse("2021-03-13"), 1, 6, supplyDao.findById(3L), null));
        plist.add(
                new ProductInstance(10L, productDao.findById(3L), 30, DateFormat.getDateInstance().parse("2020-11-01"),
                        DateFormat.getDateInstance().parse("2030-11-01"), 2, 1, supplyDao.findById(4L), null));
        plist.add(
                new ProductInstance(11L, productDao.findById(3L), 30, DateFormat.getDateInstance().parse("2020-11-01"),
                        DateFormat.getDateInstance().parse("2030-11-01"), 2, 2, supplyDao.findById(4L), null));
        plist.add(new ProductInstance(12L, productDao.findById(4L), 20,
                DateFormat.getDateInstance().parse("2021-02-12"), null, 2, 3, supplyDao.findById(5L), null));
        plist.add(new ProductInstance(13L, productDao.findById(4L), 20,
                DateFormat.getDateInstance().parse("2021-02-12"), null, 2, 4, supplyDao.findById(5L), null));
        plist.add(new ProductInstance(14L, productDao.findById(4L), 20,
                DateFormat.getDateInstance().parse("2021-04-15"), null, 2, 5, supplyDao.findById(5L), null));
        plist.add(new ProductInstance(15L, productDao.findById(4L), 20,
                DateFormat.getDateInstance().parse("2021-04-15"), null, 2, 6, supplyDao.findById(5L), null));
        plist.add(new ProductInstance(16L, productDao.findById(5L), 3, DateFormat.getDateInstance().parse("2021-01-29"),
                null, 2, 7, supplyDao.findById(6L), null));
        plist.add(new ProductInstance(17L, productDao.findById(5L), 3, DateFormat.getDateInstance().parse("2021-01-29"),
                null, 2, 8, supplyDao.findById(6L), null));
        plist.add(new ProductInstance(18L, productDao.findById(5L), 3, DateFormat.getDateInstance().parse("2021-01-29"),
                null, 2, 9, supplyDao.findById(6L), null));
        plist.add(new ProductInstance(19L, productDao.findById(6L), 1, DateFormat.getDateInstance().parse("2021-01-28"),
                null, 3, 1, supplyDao.findById(7L), orderDao.findById(4L)));
    }

    @Test
    public void testFindAllMatching1() {
        List<ProductInstance> results = dao.findAllMatching(null, null, null, null, null, null, null, null, null, null,
                null);

        System.out.println("Got instances:");
        for (ProductInstance cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected instances:");
        for (ProductInstance exp : plist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), plist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<ProductInstance> results = dao.findAllMatching(null, 19., 21., null, null, null, null, null, null, null,
                null);

        System.out.println("Got instances:");
        for (ProductInstance cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected instances:");
        System.out.println(plist.get(9));
        Assert.assertEquals(results.contains(plist.get(9)), true, "Result does not contain all rectords");
        System.out.println(plist.get(10));
        Assert.assertEquals(results.contains(plist.get(10)), true, "Result does not contain all rectords");
        System.out.println(plist.get(11));
        Assert.assertEquals(results.contains(plist.get(11)), true, "Result does not contain all rectords");
        System.out.println(plist.get(12));
        Assert.assertEquals(results.contains(plist.get(12)), true, "Result does not contain all rectords");
        System.out.println(plist.get(13));
        Assert.assertEquals(results.contains(plist.get(13)), true, "Result does not contain all rectords");
        System.out.println(plist.get(14));
        Assert.assertEquals(results.contains(plist.get(14)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 6, "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching3() throws ParseException {
        List<ProductInstance> results = dao.findAllMatching(plist.get(0).getProduct(), 10., 10.,
                DateFormat.getDateInstance().parse("2020-12-21"), DateFormat.getDateInstance().parse("2020-12-21"),
                DateFormat.getDateInstance().parse("2021-06-03"), DateFormat.getDateInstance().parse("2021-06-03"), 1,
                1, plist.get(0).getSource(), plist.get(0).getDestination());
        System.out.println("Got instances:");
        for (ProductInstance cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected instances:");
        System.out.println(plist.get(0));
        Assert.assertEquals(results.contains(plist.get(0)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }
}
