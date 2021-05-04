package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.ProductCategoryDAO;
import org.jbes.storage.entity.ProductCategory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductCategoryController {
    @RequestMapping(value = "/productcat", method = RequestMethod.GET)
    public ModelAndView productCat(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description
    ) {
        ModelAndView modelAndView = new ModelAndView("productcat");
        ProductCategoryDAO dao = WebConfig.productCategoryDAO();

        if (name != null && name.length() == 0) name = null;
        if (description != null && description.length() == 0) description = null;

        modelAndView.addObject("idvalue", id == null ? "" : id.toString());
        modelAndView.addObject("namevalue", name == null ? "" : name);
        modelAndView.addObject("descriptionvalue", description == null ? "" : description);

        if (id != null) {
            modelAndView.addObject("cats", List.of(dao.findById(id)));
        } else {
            modelAndView.addObject("cats", dao.findAllMatching(name, description));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/productcat_delete", method = RequestMethod.POST)
    public String productCatDelete(@RequestParam(required = false) Long qid) {
        ProductCategoryDAO dao = WebConfig.productCategoryDAO();
        if (qid != null) {
            ProductCategory cat = dao.findById(qid);
            if (cat != null) dao.delete(cat);
        }
        return "redirect:/productcat";
    }

    @RequestMapping(value = "/productcat_applyedit", method = RequestMethod.POST)
    public String productCatModify(
        @RequestParam(required = false) Long qid,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description
    ) {
        ProductCategoryDAO dao = WebConfig.productCategoryDAO();

        if (name != null && name.length() == 0) name = null;
        if (description != null && description.length() == 0) description = null;

        ProductCategory old;
        if (qid == null || (old = dao.findById(qid)) == null) {
            old = new ProductCategory();
            if (name != null) old.setName(name);
            if (description != null) old.setDescription(description);
            dao.save(old);
        } else {
            if (name != null) old.setName(name);
            if (description != null) old.setDescription(description);
            dao.update(old);
        }
        return "redirect:/productcat";
    }

}
