package com.lwf.springboot.controller;

import com.lwf.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/error")
public class ErrorController {
    @ResponseBody
    @RequestMapping
    public String index() {
        return "";
    }
}
