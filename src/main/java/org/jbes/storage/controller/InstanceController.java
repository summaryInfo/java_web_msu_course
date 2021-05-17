package org.jbes.storage.controller;

import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class InstanceController {
    @Autowired
    private ProductInstanceDAO dao;
    @Autowired
    private ProductDAO pdao;
    @Autowired
    private OrderDAO odao;
    @Autowired
    private SupplyDAO sdao;

    @RequestMapping(value = "/instance", method = RequestMethod.GET)
    public ModelAndView instance(@RequestParam(required = false) String errormsg,
            @RequestParam(required = false) Long id, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amount, @RequestParam(required = false) Double amounthi,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date arrival,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date arrivalhi,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date expires,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date expireshi,
            @RequestParam(required = false) Integer room, @RequestParam(required = false) Integer shelf,
            @RequestParam(required = false) Long source, @RequestParam(required = false) Long destination) {
        ModelAndView modelAndView = new ModelAndView("instance");

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        modelAndView.addObject("formatter", fmt);
        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("productvalue", product == null ? "" : product.toString());
        modelAndView.addObject("amountvalue", amount == null ? "" : amount.toString());
        modelAndView.addObject("amounthivalue", amounthi == null ? "" : amounthi.toString());
        modelAndView.addObject("arrivalvalue", arrival == null ? "" : fmt.format(arrival));
        modelAndView.addObject("arrivalhivalue", arrivalhi == null ? "" : fmt.format(arrivalhi));
        modelAndView.addObject("expiresvalue", expires == null ? "" : fmt.format(expires));
        modelAndView.addObject("expireshivalue", expireshi == null ? "" : fmt.format(expireshi));
        modelAndView.addObject("roomvalue", room == null ? "" : room.toString());
        modelAndView.addObject("shelfvalue", shelf == null ? "" : shelf.toString());
        modelAndView.addObject("sourcevalue", source == null ? "" : source.toString());
        modelAndView.addObject("destinationvalue", destination == null ? "" : destination.toString());

        if (errormsg == null)
            errormsg = "";

        List<ProductInstance> li;
        if (id != null) {
            li = new ArrayList<ProductInstance>();
            ProductInstance in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nProduct instance " + id.toString() + " is not found";
            }
        } else {
            Product prod = null;
            if (product != null) {
                prod = pdao.findById(product);
                if (prod == null) {
                    errormsg += "\nInstance product " + product.toString() + " is not found";
                }
            }

            Supply src = null;
            if (source != null) {
                src = sdao.findById(source);
                if (src == null) {
                    errormsg += "\nInstance source " + source.toString() + " is not found";
                }
            }

            Order dst = null;
            if (destination != null) {
                dst = odao.findById(destination);
                if (dst == null) {
                    errormsg += "\nInstance destination " + destination.toString() + " is not found";
                }
            }

            li = dao.findAllMatching(prod, amount, amounthi, arrival, arrivalhi, expires, expireshi, room, shelf,
                    src, dst);
        }

        modelAndView.addObject("cats", li);
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/instance_delete", method = RequestMethod.POST)
    public String instanceDelete(@RequestParam(required = false) Long qid) {
        if (qid != null) {
            ProductInstance cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/instance";
    }

    @RequestMapping(value = "/instance_applyedit", method = RequestMethod.POST)
    public String instanceModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amount,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date arrival,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date expires,
            @RequestParam(required = false) Integer room, @RequestParam(required = false) Integer shelf,
            @RequestParam(required = false) Long source, @RequestParam(required = false) Long destination) {

        boolean update = true;
        ProductInstance old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new ProductInstance();
            update = false;
            if (amount == null)
                return "redirect:/instance?errormsg=Amount%20cannot%20be%20NULL";
            if (arrival == null)
                return "redirect:/instance?errormsg=Arrival%20cannot%20be%20NULL";
            if (room == null)
                return "redirect:/instance?errormsg=Room%20cannot%20be%20NULL";
            if (shelf == null)
                return "redirect:/instance?errormsg=Shelf%20cannot%20be%20NULL";
            if (source == null)
                return "redirect:/instance?errormsg=Source%20cannot%20be%20NULL";
        }

        if (product != null) {
            Product prod = pdao.findById(product);
            if (prod == null) {
                return "redirect:/instance?errormsg=Instance%20product%20" + product.toString() + "%20is%20not%20found";
            } else {
                old.setProduct(prod);
            }
        }
        if (amount != null)
            old.setAmount(amount);
        if (arrival != null)
            old.setArrival(arrival);
        if (expires != null)
            old.setExpires(expires);
        if (room != null)
            old.setRoomNo(room);
        if (shelf != null)
            old.setShelfNo(shelf);

        if (source != null) {
            Supply src = null;
            src = sdao.findById(source);
            if (src == null) {
                return "redirect:/instance?errormsg=Instance%20source%20" + source.toString() + "%20is%20not%20found";
            } else {
                old.setSource(src);
            }
        }

        if (destination != null) {
            Order dst = null;
            dst = odao.findById(destination);
            if (dst == null) {
                return "redirect:/instance?errormsg=Instance%20destination%20" + destination.toString()
                        + "%20is%20not%20found";
            } else {
                old.setDestination(dst);
            }
        }

        if (update)
            dao.update(old);
        else
            dao.save(old);

        return "redirect:/instance";
    }

}
