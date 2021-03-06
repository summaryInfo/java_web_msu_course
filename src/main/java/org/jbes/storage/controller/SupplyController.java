package org.jbes.storage.controller;

import org.jbes.storage.dao.SupplyDAO;
import org.jbes.storage.dao.ProviderDAO;
import org.jbes.storage.dao.ProductDAO;
import org.jbes.storage.entity.Supply;
import org.jbes.storage.entity.Provider;
import org.jbes.storage.entity.Product;

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
public class SupplyController {
    @Autowired
    private SupplyDAO dao;
    @Autowired
    private ProviderDAO cdao;
    @Autowired
    private ProductDAO pdao;

    @RequestMapping(value = "/supply", method = RequestMethod.GET)
    public ModelAndView supply(@RequestParam(required = false) String errormsg, @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long provider, @RequestParam(required = false) Long product,
            @RequestParam(required = false) Double amount, @RequestParam(required = false) Double amounthi,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date time,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date timehi,
            @RequestParam(required = false) Boolean completed) {
        ModelAndView modelAndView = new ModelAndView("supply");

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        modelAndView.addObject("formatter", fmt);
        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("providervalue", provider == null ? "" : provider.toString());
        modelAndView.addObject("productvalue", product == null ? "" : product.toString());
        modelAndView.addObject("amountvalue", amount == null ? "" : amount.toString());
        modelAndView.addObject("amounthivalue", amounthi == null ? "" : amounthi.toString());
        modelAndView.addObject("timevalue", time == null ? "" : fmt.format(time));
        modelAndView.addObject("timehivalue", timehi == null ? "" : fmt.format(timehi));
        modelAndView.addObject("completedvalue", completed == null ? "" : completed.toString());

        if (errormsg == null)
            errormsg = "";

        List<Supply> li;
        if (id != null) {
            li = new ArrayList<Supply>();
            Supply in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nSupply " + id.toString() + " is not found";
            }
            modelAndView.addObject("cats", List.of(dao.findById(id)));
        } else {
            Provider cons = null;
            if (provider != null) {
                cons = cdao.findById(provider);
                if (cons == null) {
                    errormsg += "\nProvider " + provider.toString() + " is not found";
                }
            }

            Product prod = null;
            if (product != null) {
                prod = pdao.findById(product);
                if (prod == null) {
                    errormsg += "\nProduct " + product.toString() + " is not found";
                }
            }

            li = dao.findAllMatching(cons, prod, amount, amounthi, time, timehi, completed);
        }

        modelAndView.addObject("cats", li);
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/supply_delete", method = RequestMethod.POST)
    public String supplyDelete(@RequestParam(required = false) Long qid) {
        if (qid != null) {
            Supply cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/supply";
    }

    @RequestMapping(value = "/supply_applyedit", method = RequestMethod.POST)
    public String supplyModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) Long provider,
            @RequestParam(required = false) Long product, @RequestParam(required = false) Double amount,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(required = false) Date time,
            @RequestParam(required = false) Boolean completed) {

        Supply old;
        boolean update = true;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Supply();
            update = false;
            if (provider == null)
                return "redirect:/supply?errormsg=Provider%20cannot%20be%20NULL";
            if (product == null)
                return "redirect:/supply?errormsg=Product%20cannot%20be%20NULL";
            if (amount == null)
                return "redirect:/supply?errormsg=Amount%20cannot%20be%20NULL";
            if (time == null)
                return "redirect:/supply?errormsg=Time%20cannot%20be%20NULL";
            if (completed == null)
                return "redirect:/supply?errormsg=Completed%20cannot%20be%20NULL";
        }

        if (provider != null) {
            Provider cons = cdao.findById(provider);
            if (cons == null) {
                return "redirect:/supply?errormsg=Provider%20" + provider.toString() + "%20is%20not%20found";
            } else {
                old.setProvider(cons);
            }
        }
        if (product != null) {
            Product prod = pdao.findById(product);
            if (prod == null) {
                return "redirect:/supply?errormsg=Product%20" + product.toString() + "%20is%20not%20found";
            } else {
                old.setProduct(prod);
            }
        }
        if (amount != null)
            old.setAmount(amount);
        if (time != null)
            old.setTime(time);
        if (completed == null)
            completed = false;
        old.setCompleted(completed);

        if (update)
            dao.update(old);
        else
            dao.save(old);


        return "redirect:/supply";
    }
}
