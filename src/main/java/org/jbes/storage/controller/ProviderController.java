package org.jbes.storage.controller;

import org.jbes.storage.dao.ProviderDAO;
import org.jbes.storage.entity.Provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ProviderController {
    @Autowired
    private ProviderDAO dao;

    @RequestMapping(value = "/provider", method = RequestMethod.GET)
    public ModelAndView provider(@RequestParam(required = false) String errormsg,
            @RequestParam(required = false) Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description, @RequestParam(required = false) String address,
            @RequestParam(required = false) String phone, @RequestParam(required = false) String email) {
        ModelAndView modelAndView = new ModelAndView("provider");

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

        List<Provider> li;
        if (id != null) {
            li = new ArrayList<Provider>();
            Provider in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nProvider " + id.toString() + " is not found";
            }
            modelAndView.addObject("cats", List.of(dao.findById(id)));
        } else {
            li = dao.findAllMatching(name, description, address, phone, email);
        }

        modelAndView.addObject("cats", li);
        return modelAndView;
    }

    @RequestMapping(value = "/provider_delete", method = RequestMethod.POST)
    public String providerDelete(@RequestParam(required = false) Long qid) {
        if (qid != null) {
            Provider cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/provider";
    }

    @RequestMapping(value = "/provider_applyedit", method = RequestMethod.POST)
    public String providerModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) String name,
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

        boolean update = true;
        Provider old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Provider();
            update = false;
        }

        if (name != null)
            old.setName(name);
        if (description != null)
            old.setDescription(description);
        if (address != null)
            old.setAddress(address);
        if (phone != null)
            old.setTel(phone);
        if (email != null)
            old.setEmail(email);

        if (update)
            dao.update(old);
        else
            dao.save(old);

        return "redirect:/provider";
    }
}
