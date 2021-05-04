package org.jbes.storage.tests;

import java.util.ArrayList;
import java.util.List;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;
import org.jbes.storage.WebConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProviderDAOTest {
    private ProviderDAO dao;
    private List<Provider> plist;

    @BeforeClass
    public void init() {
        dao = WebConfig.providerDAO();
        plist = new ArrayList<Provider>();
        plist.add(new Provider(101L, "Food source", "Test description for food provider", new String[0],
                new String[] { "1(111)111-11-11" }, new String[] { "food@source.com" }));
        plist.add(new Provider(102L, "Chemicals source", "Test description for chemicals source", new String[0],
                new String[] { "2(222)222-22-22" }, new String[] { "contact@chemicals123.com" }));
        plist.add(new Provider(103L, "Electronics provider", "Test description for electronics provider", new String[0],
                new String[] { "3(333)333-33-33" }, new String[] { "mail@allelectronics.net" }));
    }

    @Test
    public void testFindAllMatching1() {
        List<Provider> results = dao.findAllMatching(null, null, null, null, null);

        System.out.println("Got providers:");
        for (Provider cat : results) {
            System.out.println(cat);
        }

        System.out.println("Expected providers:");
        for (Provider exp : plist) {
            System.out.println(exp);
            Assert.assertEquals(results.contains(exp), true, "Result does not contain all rectords");
        }

        Assert.assertEquals(results.size(), plist.size(), "Result contains extra elements");
    }

    @Test
    public void testFindAllMatching2() {
        List<Provider> result = dao.findAllMatching("Food source", "Test description for food provider", null,
                plist.get(0).getTel()[0], plist.get(0).getEmail()[0]);
        Assert.assertEquals(result.get(0), plist.get(0), "Result does not contain some required reults");
        Assert.assertEquals(result.size(), 1, "Non-matching results returned");
    }

    @Test
    public void testFindAllMatching3() {
        List<Provider> result = dao.findAllMatching("Something", null, null, null, null);
        Assert.assertEquals(result.size(), 0, "Non-matching results returned");
    }
}
