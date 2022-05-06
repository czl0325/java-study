package com.github.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String testIndex(Model model) {
        System.out.println("进入断点");
        return "test";
    }
}
