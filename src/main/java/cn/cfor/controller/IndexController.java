package cn.cfor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/index");
        return modelAndView;
    }
    @RequestMapping
    public ModelAndView index2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/index");
        return modelAndView;
    }


}
