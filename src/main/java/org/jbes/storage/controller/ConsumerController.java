package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.ConsumerDAO;
import org.jbes.storage.entity.Consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ConsumerController {
    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public ModelAndView consumer(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String address,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String email
    ) {
        ModelAndView modelAndView = new ModelAndView("consumer");
        ConsumerDAO dao = WebConfig.consumerDAO();

        if (name != null && name.length() == 0) name = null;
        if (description != null && description.length() == 0) description = null;
        if (address != null && address.length() == 0) address = null;
        if (phone != null && phone.length() == 0) phone = null;
        if (email != null && email.length() == 0) email = null;

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("namevalue", name == null ? "" : name);
        modelAndView.addObject("descriptionvalue", description == null ? "" : description);
        modelAndView.addObject("addressvalue", address == null ? "" : address);
        modelAndView.addObject("phonevalue", phone == null ? "" : phone);
        modelAndView.addObject("emailvalue", email == null ? "" : email);

        if (id != null) {
            modelAndView.addObject("cats", List.of(dao.findById(id)));
        } else {
            modelAndView.addObject("cats", dao.findAllMatching(name, description, address, phone, email));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/consumer_delete", method = RequestMethod.POST)
    public String consumerDelete(@RequestParam(required = false) Long qid) {
        ConsumerDAO dao = WebConfig.consumerDAO();
        if (qid != null) {
            Consumer cat = dao.findById(qid);
            if (cat != null) dao.delete(cat);
        }
        return "redirect:/consumer";
    }

    @RequestMapping(value = "/consumer_applyedit", method = RequestMethod.POST)
    public String consumerModify(
        @RequestParam(required = false) Long qid,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String address,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String email
    ) {
        ConsumerDAO dao = WebConfig.consumerDAO();

        if (name != null && name.length() == 0) name = null;
        if (description != null && description.length() == 0) description = null;
        if (address != null && address.length() == 0) address = null;
        if (phone != null && phone.length() == 0) phone = null;
        if (email != null && email.length() == 0) email = null;

        Consumer old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Consumer();
        }

        if (name != null) old.setName(name);
        if (description != null) old.setDescription(description);
        if (address != null) old.setAddress(address);
        if (phone != null) old.setTel(phone);
        if (email != null) old.setEmail(email);

        dao.saveOrUpdate(old);

        return "redirect:/consumer";
    }
}
