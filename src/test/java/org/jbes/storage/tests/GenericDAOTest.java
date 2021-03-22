package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GenericDAOTest {
    /* This works the same way for every DAO
     * object and implemented in GenericDAO, so
     * it can be tested just for one thing.
     * Also, GenericDAO does not have any public constructors */

    private GenericDAO<ProductCategory> dao;

    @BeforeClass
    public void init() {
        dao = new ProductCategoryDAO();
    }

    @Test
    public void testSave() {
        ProductCategory cat = new ProductCategory(10L, "A", "B");
        dao.save(cat);
        ProductCategory saved = dao.findById(10L);
        Assert.assertEquals(cat, saved, "Save is incorrect");
    }

    @Test
    public void testUpdate() {
        ProductCategory cat = new ProductCategory(11L, "A", "B");
        dao.save(cat);
        ProductCategory saved = dao.findById(11L);
        Assert.assertEquals(cat, saved, "Save is incorrect");
        saved.setDescription("C");
        dao.update(saved);
        ProductCategory updated = dao.findById(11L);
        Assert.assertEquals(updated, saved, "Update is incorrect");
        Assert.assertNotEquals(updated, cat, "Update does not update");
    }

    @Test
    public void testDelete() {
        ProductCategory cat = new ProductCategory(12L, "A", "B");
        dao.save(cat);
        ProductCategory saved = dao.findById(12L);
        dao.delete(saved);
        Assert.assertEquals(dao.findById(12L), null, "Delete does not work");
    }

    @Test
    public void testFindById() {
        ProductCategory c1 = new ProductCategory(1L, "Food", null);
        ProductCategory c2 = new ProductCategory(2L, "Household chemicals", null);
        Assert.assertEquals(c1, dao.findById(c1.getCategoryId()), "findById is incorrect");
        Assert.assertEquals(c2, dao.findById(c2.getCategoryId()), "findById is incorrect");
        Assert.assertEquals(null, dao.findById(13L), "findById is incorrect");
    }
}
