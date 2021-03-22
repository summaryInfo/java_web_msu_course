package org.jbes.storage.tests;

import java.text.DateFormat;
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
        Provider c1 = providerDao.findById(1L);
        Provider c2 = providerDao.findById(2L);
        Provider c3 = providerDao.findById(3L);
        Product p1 = productDao.findById(1L);
        Product p2 = productDao.findById(1L);
        Product p3 = productDao.findById(1L);
        Product p4 = productDao.findById(1L);
        Product p5 = productDao.findById(1L);
        Product p6 = productDao.findById(6L);
        plist.add(new Supply(1L, c1, p1, 20., DateFormat.getDateInstance().parse("2020-12-21"), true));
        plist.add(new Supply(2L, c1, p1, 10., DateFormat.getDateInstance().parse("2020-11-21"), true));
        plist.add(new Supply(3L, c1, p2, 10., DateFormat.getDateInstance().parse("2021-01-13"), true));
        plist.add(new Supply(4L, c2, p3, 10., DateFormat.getDateInstance().parse("2021-02-12"), true));
        plist.add(new Supply(5L, c2, p4, 10., DateFormat.getDateInstance().parse("2021-01-29"), false));
        plist.add(new Supply(6L, c3, p5, 10., DateFormat.getDateInstance().parse("2020-11-21"), true));
        plist.add(new Supply(7L, c3, p6, 10., DateFormat.getDateInstance().parse("2021-01-28"), true));
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
    public void testFindAllMatching2() throws ParseException {
        List<Supply> results = dao.findAllMatching(plist.get(0).getProvider(), plist.get(0).getProduct(), 20., 30.,
                DateFormat.getDateInstance().parse("2020-01-20"), DateFormat.getDateInstance().parse("2020-01-20"),
                true);

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
