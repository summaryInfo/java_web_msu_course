package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.jbes.storage.WebConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductDAOTest {
    private ProductDAO dao;
    private ProductCategoryDAO catdao;
    private List<ProductCategory> clist;
    private List<Product> plist;

    @BeforeClass
    public void init() {
        /* At this point db is initiallized with values from fill_tables.sql */
        dao = WebConfig.productDAO();
        catdao = WebConfig.productCategoryDAO();

        clist = new ArrayList<ProductCategory>();
        for (long i = 0; i < 4; i++) {
            clist.add(catdao.findById(i + 101L));
        }

        plist = new ArrayList<Product>();
        plist.add(new Product(101L, "Potatoes", null, clist.get(0), "Killogram", false));
        plist.add(new Product(102L, "Lemon juice (1 liter)", null, clist.get(0), "Item", false));
        plist.add(new Product(103L, "Soap", null, clist.get(1), "Item", false));
        plist.add(new Product(104L, "T-Short", null, clist.get(2), "Item", false));
        plist.add(new Product(105L, "Electric teapot", null, clist.get(3), "Item", false));
        plist.add(new Product(106L, "Refrigerator", null, clist.get(3), "Box", true));
    }

    @Test
    public void testFindAllMatching1() {
        List<Product> results = dao.findAllMatching(null, null, null, null, null);

        System.out.println("Got products:");
        for (Product cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected products:");
        for (Product exp : plist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), plist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<Product> results = dao.findAllMatching(null, null, clist.get(3), null, null);

        System.out.println("Got products:");
        for (Product cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected products:");
        System.out.println(plist.get(4));
        Assert.assertEquals(results.contains(plist.get(4)), true, "Result does not contain all rectords 1");
        System.out.println(plist.get(5));
        Assert.assertEquals(results.contains(plist.get(5)), true, "Result does not contain all rectords 2");

        Assert.assertEquals(results.size(), 2, "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching3() {
        List<Product> results = dao.findAllMatching("Electric teapot", null, clist.get(3), "Item", false);

        System.out.println("Got products:");
        for (Product cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected products:");
        System.out.println(plist.get(4));
        Assert.assertEquals(results.contains(plist.get(4)), true, "Result does not contain all rectords 1");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }
}
