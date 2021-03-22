package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ConsumerDAOTest {
    ConsumerDAO dao;
    Consumer cons;

    @BeforeClass
    public void init() {
        dao = new ConsumerDAO();
        cons = new Consumer(1L, "A potato consumer", null, new ArrayList<String>(),
                new ArrayList<String>(List.of("4(444)444-44-44")), new ArrayList<String>(List.of("ilove@potates.com")));
    }

    @Test
    public void testFindAllMatching1() {
        List<Consumer> results = dao.findAllMatching(null, null, null, null, null);
        Assert.assertEquals(results.get(0), cons, "Result does not contain some required reults");
        Assert.assertEquals(results.size(), 1, "Non-matching results returned");
    }

    @Test
    public void testFindAllMatching2() {
        List<Consumer> results = dao.findAllMatching("A potato consumer", null, null, cons.getTel().get(0), cons.getEmail().get(0));
        Assert.assertEquals(results.get(0), cons, "Result does not contain some required reults");
        Assert.assertEquals(results.size(), 1, "Non-matching results returned");
    }

    @Test
    public void testFindAllMatching3() {
        List<Consumer> result = dao.findAllMatching("Something", null, null, null, null);
        Assert.assertEquals(result.size(), 0, "Non-matching results returned");
    }
}
