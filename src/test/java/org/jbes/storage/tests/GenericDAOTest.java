package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GenericDAOTest {
    /* This works the same way for every DAO
     * object and implemented in GenericDAO, so
     * it can be tested just for one thing.
     * Also, GenericDAO does not have any public constructors */

    private GenericDAO<ProductCategory> dao;
    private List<Long> ids;

    @BeforeClass
    public void init() {
        dao = WebConfig.productCategoryDAO();
        ids = new ArrayList<Long>();
    }

    @Test
    public void testSave() {
        ProductCategory cat = new ProductCategory(0L, "A", "B");
        Long res = dao.save(cat);
        ids.add(res);
        ProductCategory saved = dao.findById(res);
        Assert.assertEquals(cat, saved, "Save is incorrect");
    }

    @Test
    public void testUpdate() {
        ProductCategory cat = new ProductCategory(0L, "A", "B");
        Long res = dao.save(cat);
        ids.add(res);
        ProductCategory saved = dao.findById(res);
        Assert.assertEquals(cat, saved, "Save is incorrect");
        saved.setDescription("C");
        dao.update(saved);
        ProductCategory updated = dao.findById(res);
        Assert.assertEquals(updated, saved, "Update is incorrect");
        Assert.assertNotEquals(updated, cat, "Update does not update");
    }

    @Test
    public void testDelete() {
        ProductCategory cat = new ProductCategory(0L, "A", "B");
        Long res = dao.save(cat);
        ids.add(res);
        ProductCategory saved = dao.findById(res);
        dao.delete(saved);
        Assert.assertEquals(dao.findById(res), null, "Delete does not work");
    }

    @Test
    public void testFindById() {
        ProductCategory c1 = new ProductCategory(101L, "Food", null);
        ProductCategory c2 = new ProductCategory(102L, "Household chemicals", null);
        Assert.assertEquals(c1, dao.findById(c1.getCategoryId()), "findById is incorrect");
        Assert.assertEquals(c2, dao.findById(c2.getCategoryId()), "findById is incorrect");
        Assert.assertEquals(null, dao.findById(13L), "findById is incorrect");
    }

    @AfterClass
    public void cleanup() {
        for (Long id : ids) {
            ProductCategory ent = dao.findById(id);
            if (ent != null) {
                dao.delete(ent);
            }
        }
    }
}
