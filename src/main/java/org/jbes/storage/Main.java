package org.jbes.storage;


import org.jbes.storage.entity.*;
import org.jbes.storage.dao.*;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        ConsumerDAO dao = new ConsumerDAO();
        List<Consumer> res = dao.findAllMatching(null, null, null, null, null);
        for (Consumer consumer : res) {
            System.out.println(consumer);
        }
    }
}
