package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class UserCredentialController {

    @Autowired
    UserCredentialService userCredentialService;

    @RequestMapping("/index/addUser")
    public String addNewUser(UserCredential userCredential, Model model){
        userCredentialService.addUser(userCredential);
        model.addAttribute( "no,m_du_model_dans_la_vue", userCredential);
        return "add_user_View";
    }

    @RequestMapping("/index/user/{email}/{password}")
    public String findUserOptional(@PathVariable String email, @PathVariable String password, Model model ){
        Optional<UserCredential> userCredential = userCredentialService.findOptionalUserByEmailAndPassword(email, password);
        model.addAttribute( "nom_du_model_dans_la_vue", userCredential);
        return "view";
    }

    @RequestMapping("/index/user/{email}/{password}")
    public String findUser(@PathVariable String email, @PathVariable String password, Model model){
        UserCredential userCredential = userCredentialService.getUserByEmailAndPassword(email, password);
        model.addAttribute("nom_du_model_dans_la_vue", userCredential);
        return "view";
    }

}
