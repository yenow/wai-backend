package com.zootopia.zootopiaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
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

    @GetMapping("hello-string")
    @ResponseBody   //  HTTP 프로토콜의 Body 부분에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam(name ="name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // 자바 빈 규약, 프로퍼티 접근 방식, 캡슐화..
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

