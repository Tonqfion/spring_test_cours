package com.cours.project_spring_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {
        System.out.println("/ : Home Page");
        return "home";
    }

}
