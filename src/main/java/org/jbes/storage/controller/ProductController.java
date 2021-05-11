package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.ProductDAO;
import org.jbes.storage.dao.ProductCategoryDAO;
import org.jbes.storage.entity.Product;
import org.jbes.storage.entity.ProductCategory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ArrayList;

@Controller
public class ProductController {
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView product(@RequestParam(required = false) String errormsg,
            @RequestParam(required = false) Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description, @RequestParam(required = false) Long category,
            @RequestParam(required = false) String unit, @RequestParam(required = false) Boolean oversized) {
        ModelAndView modelAndView = new ModelAndView("product");
        ProductDAO dao = WebConfig.productDAO();
        ProductCategoryDAO cdao = WebConfig.productCategoryDAO();

        if (name != null && name.length() == 0)
            name = null;
        if (description != null && description.length() == 0)
            description = null;
        if (unit != null && unit.length() == 0)
            unit = null;

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("namevalue", name == null ? "" : name);
        modelAndView.addObject("descriptionvalue", description == null ? "" : description);
        modelAndView.addObject("categoryvalue", category == null ? "" : category.toString());
        modelAndView.addObject("unitvalue", unit == null ? "" : unit);
        modelAndView.addObject("oversizedvalue", oversized == null ? "" : oversized.toString());

        if (errormsg == null)
            errormsg = "";

        List<Product> li;
        if (id != null) {
            li = new ArrayList<Product>();
            Product in = dao.findById(id);
            if (in != null) {
                li.add(in);
            } else {
                errormsg += "\nProduct " + id.toString() + " is not found";
            }
        } else {
            ProductCategory cat = null;
            if (category != null) {
                cat = cdao.findById(category);
                if (cat == null) {
                    errormsg += "\nCategory " + category.toString() + " is not found";
                }
            }
            li = dao.findAllMatching(name, description, cat, unit, oversized);
        }

        modelAndView.addObject("cats", li);
        modelAndView.addObject("errormsg", errormsg);
        return modelAndView;
    }

    @RequestMapping(value = "/product_delete", method = RequestMethod.POST)
    public String productDelete(@RequestParam(required = false) Long qid) {
        ProductDAO dao = WebConfig.productDAO();
        if (qid != null) {
            Product cat = dao.findById(qid);
            if (cat != null)
                dao.delete(cat);
        }
        return "redirect:/product";
    }

    @RequestMapping(value = "/product_applyedit", method = RequestMethod.POST)
    public String productModify(@RequestParam(required = false) Long qid, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description, @RequestParam(required = false) Long category,
            @RequestParam(required = false) String unit, @RequestParam(required = false) Boolean oversized) {
        ProductDAO dao = WebConfig.productDAO();
        ProductCategoryDAO cdao = WebConfig.productCategoryDAO();

        if (name != null && name.length() == 0)
            name = null;
        if (description != null && description.length() == 0)
            description = null;
        if (unit != null && unit.length() == 0)
            unit = null;

        Product old;
        boolean update = true;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new Product();
            update = false;
        }

        if (name != null)
            old.setName(name);
        if (description != null)
            old.setDescription(description);
        if (category != null) {
            ProductCategory cat = cdao.findById(category);
            if (cat == null) {
                return "redirect:/product?errormsg=Product%20category%20" + category.toString() + "%20is%20not%20found";
            } else {
                old.setCategory(cat);
            }
        }
        if (unit != null)
            old.setUnit(unit);
        if (oversized != null)
            old.setOversized(oversized);

        if (update)
            dao.update(old);
        else
            dao.save(old);

        return "redirect:/product";
    }
}
