package org.jbes.storage.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        productDao = new ProductDAO();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        plist = new ArrayList<ProductInstance>();
        plist.add(new ProductInstance(101L, productDao.findById(101L), 10, fmt.parse("2020-12-21"), fmt.parse("2021-06-03"),
                1, 1, supplyDao.findById(101L), orderDao.findById(102L)));
        plist.add(new ProductInstance(102L, productDao.findById(101L), 10, fmt.parse("2020-12-21"), fmt.parse("2021-06-03"),
                1, 1, supplyDao.findById(101L), orderDao.findById(102L)));
        plist.add(new ProductInstance(103L, productDao.findById(101L), 10, fmt.parse("2020-12-21"), fmt.parse("2021-06-03"),
                1, 2, supplyDao.findById(101L), orderDao.findById(102L)));
        plist.add(new ProductInstance(104L, productDao.findById(101L), 10, fmt.parse("2020-12-21"), fmt.parse("2021-06-03"),
                1, 2, supplyDao.findById(101L), orderDao.findById(103L)));
        plist.add(new ProductInstance(105L, productDao.findById(101L), 15, fmt.parse("2020-11-17"), fmt.parse("2021-04-03"),
                1, 3, supplyDao.findById(102L), orderDao.findById(103L)));
        plist.add(new ProductInstance(106L, productDao.findById(101L), 15, fmt.parse("2020-11-17"), fmt.parse("2021-04-03"),
                1, 3, supplyDao.findById(102L), orderDao.findById(103L)));
        plist.add(new ProductInstance(107L, productDao.findById(101L), 15, fmt.parse("2020-11-17"), fmt.parse("2021-04-03"),
                1, 3, supplyDao.findById(102L), null));
        plist.add(new ProductInstance(108L, productDao.findById(102L), 6, fmt.parse("2021-01-13"), fmt.parse("2021-03-13"),
                1, 5, supplyDao.findById(103L), null));
        plist.add(new ProductInstance(109L, productDao.findById(102L), 6, fmt.parse("2021-01-13"), fmt.parse("2021-03-13"),
                1, 6, supplyDao.findById(103L), null));
        plist.add(new ProductInstance(110L, productDao.findById(103L), 30, fmt.parse("2020-11-01"),
                fmt.parse("2030-11-01"), 2, 1, supplyDao.findById(104L), null));
        plist.add(new ProductInstance(111L, productDao.findById(103L), 30, fmt.parse("2020-11-01"),
                fmt.parse("2030-11-01"), 2, 2, supplyDao.findById(104L), null));
        plist.add(new ProductInstance(112L, productDao.findById(104L), 20, fmt.parse("2021-02-12"), null, 2, 3,
                supplyDao.findById(105L), null));
        plist.add(new ProductInstance(113L, productDao.findById(104L), 20, fmt.parse("2021-02-12"), null, 2, 4,
                supplyDao.findById(105L), null));
        plist.add(new ProductInstance(114L, productDao.findById(104L), 20, fmt.parse("2021-04-15"), null, 2, 5,
                supplyDao.findById(105L), null));
        plist.add(new ProductInstance(115L, productDao.findById(104L), 20, fmt.parse("2021-04-15"), null, 2, 6,
                supplyDao.findById(105L), null));
        plist.add(new ProductInstance(116L, productDao.findById(105L), 3, fmt.parse("2021-01-29"), null, 2, 7,
                supplyDao.findById(106L), null));
        plist.add(new ProductInstance(117L, productDao.findById(105L), 3, fmt.parse("2021-01-29"), null, 2, 8,
                supplyDao.findById(106L), null));
        plist.add(new ProductInstance(118L, productDao.findById(105L), 3, fmt.parse("2021-01-29"), null, 2, 9,
                supplyDao.findById(106L), null));
        plist.add(new ProductInstance(119L, productDao.findById(106L), 1, fmt.parse("2021-01-28"), null, 3, 1,
                supplyDao.findById(107L), orderDao.findById(104L)));
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
        System.out.println(plist.get(11));
        Assert.assertEquals(results.contains(plist.get(11)), true, "Result does not contain all rectords");
        System.out.println(plist.get(12));
        Assert.assertEquals(results.contains(plist.get(12)), true, "Result does not contain all rectords");
        System.out.println(plist.get(13));
        Assert.assertEquals(results.contains(plist.get(13)), true, "Result does not contain all rectords");
        System.out.println(plist.get(14));
        Assert.assertEquals(results.contains(plist.get(14)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 4, "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching3() {
        List<ProductInstance> results = dao.findAllMatching(plist.get(18).getProduct(), 1., 1.,
                plist.get(18).getArrival(), plist.get(18).getArrival(), plist.get(18).getExpires(),
                plist.get(18).getExpires(), 3, 1, plist.get(18).getSource(), plist.get(18).getDestination());
        System.out.println("Got instances:");
        for (ProductInstance cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected instances:");
        System.out.println(plist.get(18));
        Assert.assertEquals(results.contains(plist.get(18)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }
}
