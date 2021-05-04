package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.ProductCategoryDAO;

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
}
