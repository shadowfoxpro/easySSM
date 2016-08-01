package com.treeinjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuiyingjia on 16/8/1.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/index");
        return modelAndView;
    }



}
