package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductCategoryDAOTest {
    private List<ProductCategory> clist;
    private ProductCategoryDAO dao;

    @BeforeClass
    public void init() {
        /* At this point db is initiallized with values from fill_tables.sql */
        dao = new ProductCategoryDAO();
        clist = new ArrayList<ProductCategory>();
        clist.add(new ProductCategory(101L, "Food", null));
        clist.add(new ProductCategory(102L, "Household chemicals", null));
        clist.add(new ProductCategory(103L, "Clothes", null));
        clist.add(new ProductCategory(104L, "Consumer electronics", null));
    }

    @Test
    public void testFindAllMatching1() {
        List<ProductCategory> results = dao.findAllMatching(null, null);

        System.out.println("Got caterories:");
        for (ProductCategory cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected caterories:");

        for (ProductCategory exp : clist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), clist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<ProductCategory> results = dao.findAllMatching("Food", null);

        System.out.println("Got categories:");
        for (ProductCategory cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected categories:");

        System.out.println(clist.get(0));
        Assert.assertEquals(results.contains(clist.get(0)), true, "Result does not contain all rectords");

        Assert.assertEquals(results.size(), 1, "Result contains extra elements");
    }
}
