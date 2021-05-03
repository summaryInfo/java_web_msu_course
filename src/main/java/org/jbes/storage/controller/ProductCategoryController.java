package org.jbes.storage.controller;

import org.jbes.storage.WebConfig;
import org.jbes.storage.dao.ProductCategoryDAO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCategoryController {
    @RequestMapping(value = "/productcat", method = RequestMethod.GET)
    public ModelAndView productCat() {
        ModelAndView modelAndView = new ModelAndView("productcat");
        ProductCategoryDAO dao = WebConfig.productCategoryDAO();
        // TODO Implement input fields
        modelAndView.addObject("cats", dao.findAllMatching(null, null));
        return modelAndView;
    }
}
