package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    UserCredentialService userCredentialService;

    @PostMapping("/register")
    public String register(UserCredential userCredential){
        try{
            System.out.println(userCredential);
            userCredentialService.addUser(userCredential);
        }
        catch (Exception e){
            e.printStackTrace();
            return "register";
        }
        return "redirect:home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest httpServletRequest) throws Exception {
        httpServletRequest.logout();
        return "redirect:/";
    }

}
