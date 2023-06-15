package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiSwaggerController {

    @GetMapping("/swagger.html")
    public String getSwaggerHtml() {
        return "swagger.html";
    }
}
