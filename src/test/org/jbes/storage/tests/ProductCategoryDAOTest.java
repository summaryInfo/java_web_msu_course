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
        ProductCategory c1 = new ProductCategory();
        c1.setCategoryId(1L);
        c1.setName("продукты");
        Assert.assertEquals(results.contains(c1), true, "Result does not contain all rectords");
        ProductCategory c2 = new ProductCategory();
        c2.setCategoryId(2L);
        c2.setName("бытовая химия");
        Assert.assertEquals(results.contains(c2), true, "Result does not contain all rectords");
        ProductCategory c3 = new ProductCategory();
        c3.setCategoryId(3L);
        c3.setName("одежда/обувь");
        Assert.assertEquals(results.contains(c3), true, "Result does not contain all rectords");
        results.contains(c3);
        ProductCategory c4 = new ProductCategory();
        c4.setCategoryId(4L);
        c4.setName("бытовая электроника");
        Assert.assertEquals(results.contains(c4), true, "Result does not contain all rectords");
    }
}
