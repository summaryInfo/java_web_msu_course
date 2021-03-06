package org.jbes.storage.controller;

import org.jbes.storage.dao.ConsumerDAO;
import org.jbes.storage.entity.Consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ConsumerController {
    @Autowired
    private ConsumerDAO dao;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public ModelAndView consumer(@RequestParam(required = false) String errormsg,
            @RequestParam(required = false) Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description, @RequestParam(required = false) String address,
            @RequestParam(required = false) String phone, @RequestParam(required = false) String email) {
        ModelAndView modelAndView = new ModelAndView("consumer");

        if (name != null && name.length() == 0)
            name = null;
        if (description != null && description.length() == 0)
            description = null;
        if (address != null && address.length() == 0)
            address = null;
        if (phone != null && phone.length() == 0)
            phone = null;
        if (email != null && email.length() == 0)
            email = null;

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("namevalue", name == null ? "" : name);
        modelAndView.addObject("descriptionvalue", description == null ? "" : description);
        modelAndView.addObject("addressvalue", address == null ? "" : address);
        modelAndView.addObject("phonevalue", phone == null ? "" : phone);
        modelAndView.addObject("emailvalue", email == null ? "" : email);
        modelAndView.addObject("errormsg", errormsg == null ? "" : errormsg);

        List<Consumer> li;
        if (id != null) {
            li = new ArrayList<Consumer>();
            Consumer in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nConsumer " + id.toString() + " is not found";
            }
        } else {
            li = dao.findAllMatching(name, description, address, phone, email);
        }
        modelAndView.addObject("cats", li);
        return modelAndView;
    }

    @RequestMapping(value = "/consumer_delete", method = RequestMethod.POST)
    public String consumerDelete(@RequestParam(required = false) Long qid) {
        if (qid != null) {
            Consumer cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/consumer";
    }

    @RequestMapping(value = "/consumer_applyedit", method = RequestMethod.POST)
    public String consumerModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description, @RequestParam(required = false) String address,
            @RequestParam(required = false) String phone, @RequestParam(required = false) String email) {
        if (name != null && name.length() == 0)
            name = null;
        if (description != null && description.length() == 0)
            description = null;
        if (address != null && address.length() == 0)
            address = null;
        if (phone != null && phone.length() == 0)
            phone = null;
        if (email != null && email.length() == 0)
            email = null;

        Consumer old;
        boolean update = true;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Consumer();
            update = false;
            if (name == null)
                return "redirect:/consumer?errormsg=Name%20cannot%20be%20NULL";
        }

        if (name != null)
            old.setName(name);
        if (description != null)
            old.setDescription(description);
        if (address != null)
            old.setAddress(address);
        if (phone != null)
            old.setPhone(phone);
        if (email != null)
            old.setEmail(email);

        if (update)
            dao.update(old);
        else
            dao.save(old);

        return "redirect:/consumer";
    }
}
