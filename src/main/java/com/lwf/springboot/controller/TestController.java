package com.lwf.springboot.controller;

import com.lwf.springboot.model.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwf on 2017/3/1.
 */

@Controller
@RequestMapping("/test")
public class TestController {
    public static List<User> users = new ArrayList<User>();

    @RequestMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/index");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public List<User> GetAll() {
        return users;
    }

    @RequestMapping("/adduser")
    public int AddUser(User user, HttpServletRequest request) {  //, HttpServletResponse response
        String userName = request.getParameter("userName");
        //response.setStatus(1);
        users.add(user);
        return 1;
    }

    @RequestMapping("/test1")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/test1");
        return mv;
    }
}