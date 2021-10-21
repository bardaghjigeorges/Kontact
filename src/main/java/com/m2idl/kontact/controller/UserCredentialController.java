package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.ContactService;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class UserCredentialController {

    @Autowired
    UserCredentialService userCredentialService;

    @Autowired
    ContactService contactService;

    @GetMapping("/home")
    public ModelAndView findUserOptional(Principal principal){
        List<Contact> contacts = userCredentialService.getContactsOfUser(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contact", contacts);
        return modelAndView;
    }

    @GetMapping("/contact/edit")
    public String getContactEdit(){
        //todo à completer
        return "contactEdit";
    }

    @PostMapping("/contact/edit")
    public String postContactEdit(@RequestBody Contact contact){
        //todo à completer
        return "contactEdit";
    }

    @PostMapping("/addContact")
    public String addAContactToUser(Principal principal, Contact contact ){
        //ajouter un contact à un user avec la userServiceCrednetial on ne renvoie pas de model on ajoute juste
        userCredentialService.addContactToUser(principal.getName(), contact);
        return "redirect:home";
    }

    @DeleteMapping("deleteContact")
    public String deleteContact(Principal principal, Contact contact){
        userCredentialService.deleteContact(principal.getName(), contact);
        return "redirect:home";
    }
}
