package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.*;
import org.jbes.storage.entity.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class InstanceController {
    @RequestMapping(value = "/instance", method = RequestMethod.GET)
    public ModelAndView instance(@RequestParam(required = false) String errormsg,
            @RequestParam(required = false) Long id, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amountlo, @RequestParam(required = false) Double amounthi,
            @RequestParam(required = false) Date arrivallo, @RequestParam(required = false) Date arrivalhi,
            @RequestParam(required = false) Date expireslo, @RequestParam(required = false) Date expireshi,
            @RequestParam(required = false) Integer room, @RequestParam(required = false) Integer shelf,
            @RequestParam(required = false) Long source, @RequestParam(required = false) Long destination) {
        ModelAndView modelAndView = new ModelAndView("instance");
        ProductInstanceDAO dao = WebConfig.productInstanceDAO();
        ProductDAO pdao = WebConfig.productDAO();
        OrderDAO odao = WebConfig.orderDAO();
        SupplyDAO sdao = WebConfig.supplyDAO();

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("productvalue", product == null ? "" : product.toString());
        modelAndView.addObject("amountlovalue", amountlo == null ? "" : amountlo.toString());
        modelAndView.addObject("amounthivalue", amounthi == null ? "" : amounthi.toString());
        modelAndView.addObject("arrivallovalue", arrivallo == null ? "" : arrivallo.toString());
        modelAndView.addObject("arrivalhivalue", arrivalhi == null ? "" : arrivalhi.toString());
        modelAndView.addObject("expireslovalue", expireslo == null ? "" : expireslo.toString());
        modelAndView.addObject("expireshivalue", expireshi == null ? "" : expireshi.toString());
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
                    errormsg += "\nInstance product " + product + " is not found";
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

            li = dao.findAllMatching(prod, amountlo, amounthi, arrivallo, arrivalhi, expireslo, expireshi, room, shelf,
                    src, dst);
        }

        modelAndView.addObject("cats", li);
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/instance_delete", method = RequestMethod.POST)
    public String instanceDelete(@RequestParam(required = false) Long qid) {
        ProductInstanceDAO dao = WebConfig.productInstanceDAO();
        if (qid != null) {
            ProductInstance cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/instance";
    }

    @RequestMapping(value = "/instance_applyedit", method = RequestMethod.POST)
    public String instanceModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amount, @RequestParam(required = false) Date arrival,
            @RequestParam(required = false) Date expires, @RequestParam(required = false) Integer room,
            @RequestParam(required = false) Integer shelf, @RequestParam(required = false) Long source,
            @RequestParam(required = false) Long destination) {
        ProductInstanceDAO dao = WebConfig.productInstanceDAO();
        ProductDAO pdao = WebConfig.productDAO();
        OrderDAO odao = WebConfig.orderDAO();
        SupplyDAO sdao = WebConfig.supplyDAO();

        ProductInstance old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new ProductInstance();
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
        dao.saveOrUpdate(old);

        return "redirect:/instance";
    }

}
