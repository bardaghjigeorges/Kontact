package com.m2idl.kontact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping(value = "/")
    public String home(){
        return "redirect:/home";
    }
}
