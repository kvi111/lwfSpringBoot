package com.lwf.springboot.controller;

import com.lwf.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lwf on 2017/3/1.
 */

@Controller
@RequestMapping("test")
public class TestController {
    public static List<User> users = new ArrayList<User>();

    @RequestMapping
    public ModelAndView index() {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("intYear",2017);
        return new ModelAndView("test/index",data);
    }

    @ResponseBody
    @RequestMapping("getall")
    public List<User> GetAll() {
        return users;
    }

    @ResponseBody
    @RequestMapping("adduser")
    public Map AddUser(@RequestBody User user, HttpServletResponse response) {  //,
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (user.getUserName() != null) {
            users.add(user);
            resultMap.put("Code", "1");
            resultMap.put("Msg", "success");
        } else {
            resultMap.put("Code", "0");
            resultMap.put("Msg", "failer");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("deluser")
    public Map DelUser(@RequestBody User user, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (user.getUserName() != null) {
            users.removeIf(s -> s.getUserName().equals(user.getUserName()));
            resultMap.put("Code", "1");
            resultMap.put("Msg", "success");
        } else {
            resultMap.put("Code", "0");
            resultMap.put("Msg", "failer");
        }
        return resultMap;
    }

    @RequestMapping("test1")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test/test1");
        return mv;
    }
}