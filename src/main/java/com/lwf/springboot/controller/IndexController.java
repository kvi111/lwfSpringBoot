package com.lwf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class IndexController {

    @RequestMapping
    public String index0() {
        return "test/index";
    }

//    @RequestMapping("/")
//    public String index() {
//        return "forward:test/index";
//    }
}