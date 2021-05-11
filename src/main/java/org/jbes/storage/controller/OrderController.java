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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class OrderController {
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView order(@RequestParam(required = false) String errormsg, @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long consumer, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amountlo, @RequestParam(required = false) Double amounthi,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date timelo,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date timehi,
            @RequestParam(required = false) Boolean completed) {
        ModelAndView modelAndView = new ModelAndView("order");
        OrderDAO dao = WebConfig.orderDAO();
        ConsumerDAO cdao = WebConfig.consumerDAO();
        ProductDAO pdao = WebConfig.productDAO();

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        modelAndView.addObject("formatter", fmt);
        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("consumervalue", consumer == null ? "" : consumer.toString());
        modelAndView.addObject("productvalue", product == null ? "" : product.toString());
        modelAndView.addObject("amountlovalue", amountlo == null ? "" : amountlo.toString());
        modelAndView.addObject("amounthivalue", amounthi == null ? "" : amounthi.toString());
        modelAndView.addObject("timelovalue", timelo == null ? "" : fmt.format(timelo));
        modelAndView.addObject("timehivalue", timehi == null ? "" : fmt.format(timehi));
        modelAndView.addObject("completedvalue", completed == null ? "" : completed.toString());

        if (errormsg == null)
            errormsg = "";

        List<Order> li;
        if (id != null) {
            li = new ArrayList<Order>();
            Order in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nOrder " + id.toString() + " is not found";
            }
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

            li = dao.findAllMatching(cons, prod, amountlo, amounthi, timelo, timehi, completed);
        }

        modelAndView.addObject("cats", li);
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/order_delete", method = RequestMethod.POST)
    public String orderDelete(@RequestParam(required = false) Long qid) {
        OrderDAO dao = WebConfig.orderDAO();
        if (qid != null) {
            Order cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/order";
    }

    @RequestMapping(value = "/order_applyedit", method = RequestMethod.POST)
    public String orderModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) Long consumer,
            @RequestParam(required = false) Long product, @RequestParam(required = false) Double amount,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date time,
            @RequestParam(required = false) Boolean completed) {
        OrderDAO dao = WebConfig.orderDAO();
        ConsumerDAO cdao = WebConfig.consumerDAO();
        ProductDAO pdao = WebConfig.productDAO();

        Order old;
        boolean update = true;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Order();
            update = false;
            if (consumer == null)
                return "redirect:/consumer?errormsg=Consumer%20cannot%20be%20NULL";
            if (product == null)
                return "redirect:/consumer?errormsg=Product%20cannot%20be%20NULL";
            if (amount == null)
                return "redirect:/consumer?errormsg=Amount%20cannot%20be%20NULL";
            if (time == null)
                return "redirect:/consumer?errormsg=Time%20cannot%20be%20NULL";
            if (completed == null)
                return "redirect:/consumer?errormsg=Completed%20cannot%20be%20NULL";
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
        if (amount != null)
            old.setAmount(amount);
        if (time != null)
            old.setTime(time);
        if (completed != null)
            old.setCompleted(completed);

        if (update)
            dao.update(old);
        else
            dao.save(old);

        return "redirect:/order";
    }
}
