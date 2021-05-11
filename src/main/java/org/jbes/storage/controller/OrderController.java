package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.OrderDAO;
import org.jbes.storage.dao.ConsumerDAO;
import org.jbes.storage.dao.ProductDAO;
import org.jbes.storage.entity.Order;
import org.jbes.storage.entity.Consumer;
import org.jbes.storage.entity.Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Date;

@Controller
public class OrderController {
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView order(
        @RequestParam(required = false) String errormsg,
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) Long consumer,
        @RequestParam(required = false) Long product,
        @RequestParam(required = false) Double amountlo,
        @RequestParam(required = false) Double amounthi,
        @RequestParam(required = false) Date timelo,
        @RequestParam(required = false) Date timehi,
        @RequestParam(required = false) Boolean completed
    ) {
        ModelAndView modelAndView = new ModelAndView("order");
        OrderDAO dao = WebConfig.orderDAO();
        ConsumerDAO cdao = WebConfig.consumerDAO();
        ProductDAO pdao = WebConfig.productDAO();

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("consumervalue", consumer == null ? "" : consumer.toString());
        modelAndView.addObject("productvalue", product == null ? "" : product.toString());
        modelAndView.addObject("amountlovalue", amountlo == null ? "" : amountlo.toString());
        modelAndView.addObject("amounthivalue", amounthi == null ? "" : amounthi.toString());
        modelAndView.addObject("timelovalue", timelo == null ? "" : timelo.toString());
        modelAndView.addObject("timehivalue", timehi == null ? "" : timehi.toString());
        modelAndView.addObject("completedvalue", completed == null ? "" : completed.toString());

        if (errormsg == null) errormsg = "";

        if (id != null) {
            modelAndView.addObject("cats", List.of(dao.findById(id)));
        } else {
            Consumer cons = null;
            if (consumer != null) {
                cons = cdao.findById(consumer);
                if (cons == null) {
                    errormsg += "\nConsumer " + consumer.toString() + " is not found!";
                }
            }

            Product prod = null;
            if (product != null) {
                prod = pdao.findById(product);
                if (prod == null) {
                    errormsg += "\nProduct " + product.toString() + " is not found!";
                }
            }

            modelAndView.addObject("cats", dao.findAllMatching(cons, prod, amountlo,
                                                               amounthi, timelo, timehi, completed));
        }
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/order_delete", method = RequestMethod.POST)
    public String orderDelete(@RequestParam(required = false) Long qid) {
        OrderDAO dao = WebConfig.orderDAO();
        if (qid != null) {
            Order cat = dao.findById(qid);
            if (cat != null) dao.delete(cat);
        }
        return "redirect:/order";
    }

    @RequestMapping(value = "/order_applyedit", method = RequestMethod.POST)
    public String orderModify(
        @RequestParam(required = false) Long qid,
        @RequestParam(required = false) Long consumer,
        @RequestParam(required = false) Long product,
        @RequestParam(required = false) Double amount,
        @RequestParam(required = false) Date time,
        @RequestParam(required = false) Boolean completed
    ) {
        OrderDAO dao = WebConfig.orderDAO();
        ConsumerDAO cdao = WebConfig.consumerDAO();
        ProductDAO pdao = WebConfig.productDAO();

        Order old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Order();
        }

        if (consumer != null) {
            Consumer cons = cdao.findById(consumer);
            if (cons == null) {
                return "redirect:/order?errormsg=Consumer%20" + consumer.toString() + "%20is%20not%20found!";
            } else {
                old.setConsumer(cons);
            }
        }
        if (product != null) {
            Product prod = pdao.findById(product);
            if (prod == null) {
                return "redirect:/order?errormsg=Product%20" + product.toString() + "%20is%20not%20found!";
            } else {
                old.setProduct(prod);
            }
        }
        if (amount != null) old.setAmount(amount);
        if (time != null) old.setTime(time);
        if (completed != null) old.setCompleted(completed);

        dao.saveOrUpdate(old);

        return "redirect:/order";
    }
}