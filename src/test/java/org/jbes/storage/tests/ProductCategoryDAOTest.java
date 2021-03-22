package org.jbes.storage.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import java.util.List;

public class ProductCategoryDAOTest {
    @Test
    public void testFindAllMatching() {
        /* At this point db is initiallized with values from fill_tables.sql */
        ProductCategoryDAO dao = new ProductCategoryDAO();
        List<ProductCategory> results = dao.findAllMatching(null, null);
        System.out.println("Got caterories:");
        for (ProductCategory cat : results) {
            System.out.println(cat.toString());
        }
        System.out.println("Expected caterories:");
        ProductCategory c1 = new ProductCategory();
        c1.setCategoryId(1L);
        c1.setName("продукты");
        c1.setDescription(null);
        System.out.println(c1.toString());
        Assert.assertEquals(results.contains(c1), true, "Result does not contain all rectords 1");
        ProductCategory c2 = new ProductCategory();
        c2.setCategoryId(2L);
        c2.setName("бытовая химия");
        c2.setDescription(null);
        System.out.println(c2.toString());
        Assert.assertEquals(results.contains(c2), true, "Result does not contain all rectords 2");
        ProductCategory c3 = new ProductCategory();
        c3.setCategoryId(3L);
        c3.setName("одежда/обувь");
        c3.setDescription(null);
        System.out.println(c3.toString());
        Assert.assertEquals(results.contains(c3), true, "Result does not contain all rectords 3");
        results.contains(c3);
        ProductCategory c4 = new ProductCategory();
        c4.setCategoryId(4L);
        c4.setName("бытовая электроника");
        c4.setDescription(null);
        System.out.println(c4.toString());
        Assert.assertEquals(results.contains(c4), true, "Result does not contain all rectords 4");
    }
}
