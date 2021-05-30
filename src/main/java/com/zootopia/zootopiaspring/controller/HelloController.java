package com.zootopia.zootopiaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model) {
        System.out.println("hello");
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(name ="name") String name, Model model) {
        model.addAttribute("name",name); // name이 null 이라서 view에서 에러를 발생시킨듯...
        return "hello-template";
    }
}

