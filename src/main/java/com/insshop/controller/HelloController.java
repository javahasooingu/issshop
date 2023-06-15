package com.insshop.controller;


import com.insshop.dto.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        model.addAttribute("name", name);

        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloMvc(@RequestParam("name")String name){

        return "hello!!" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public User helloApi(@RequestParam("name")String name){
        User user = User.createUser("testhhh24Email@google.com", "pwd2", name, "12345", "성남", "1238호");

        return user;
    }

}
