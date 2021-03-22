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

public class SupplyDAOTest {
    SupplyDAO dao;
    ProductDAO productDao;
    ProviderDAO providerDao;
    List<Supply> plist;

    @BeforeClass
    public void init() throws ParseException {
        dao = new SupplyDAO();
        productDao = new ProductDAO();
        providerDao = new ProviderDAO();

        plist = new ArrayList<Supply>();
        Provider c1 = providerDao.findById(101L);
        Provider c2 = providerDao.findById(102L);
        Provider c3 = providerDao.findById(103L);
        Product p1 = productDao.findById(101L);
        Product p2 = productDao.findById(102L);
        Product p3 = productDao.findById(103L);
        Product p4 = productDao.findById(104L);
        Product p5 = productDao.findById(105L);
        Product p6 = productDao.findById(106L);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        plist.add(new Supply(101L, c1, p1, 20., fmt.parse("2020-12-21"), true));
        plist.add(new Supply(102L, c1, p1, 10., fmt.parse("2020-11-21"), true));
        plist.add(new Supply(103L, c1, p2, 10., fmt.parse("2021-01-13"), true));
        plist.add(new Supply(104L, c2, p3, 10., fmt.parse("2021-02-12"), true));
        plist.add(new Supply(105L, c2, p4, 10., fmt.parse("2021-01-29"), false));
        plist.add(new Supply(106L, c3, p5, 10., fmt.parse("2020-11-21"), true));
        plist.add(new Supply(107L, c3, p6, 10., fmt.parse("2021-01-28"), true));
    }

    @Test
    public void testFindAllMatching1() {
        List<Supply> results = dao.findAllMatching(null, null, null, null, null, null, null);

        System.out.println("Got supplies:");
        for (Supply cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected supplies:");

        for (Supply exp : plist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), plist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<Supply> results = dao.findAllMatching(plist.get(0).getProvider(), plist.get(0).getProduct(), 20., 30.,
                plist.get(0).getTime(), plist.get(0).getTime(), true);

        System.out.println("Got supplies:");
        for (Supply cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected supplies:");

        System.out.println(plist.get(0));
        Assert.assertEquals(results.contains(plist.get(0)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching3() {
        List<Supply> results = dao.findAllMatching(null, null, 200., 300., null, null, true);
        Assert.assertEquals(results.size(), 0, "Non-matching results returned");
    }
}
