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
        System.out.println("current user : "+principal.getName());
        List<Contact> contacts = userCredentialService.getContactsOfUser(principal.getName());
        ModelAndView modelAndView = new ModelAndView("contactsList");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @GetMapping("/contact/edit/{id}")
    public ModelAndView getContactEdit(@PathVariable(value = "id") int id ){
        Contact contact = contactService.getContact(id);
        ModelAndView modelAndView = new ModelAndView("contactEdit");
        modelAndView.addObject("contact", contact);
        return modelAndView ;
    }

    @PostMapping("/contact/edit/{id}")
    public ModelAndView putContactEdit(@PathVariable(value = "id") int id, @ModelAttribute("contact") Contact contact) throws Exception {
        Contact newContact = contactService.updateContact(contact, id);
        ModelAndView modelAndView = new ModelAndView("contactEdit");
        modelAndView.addObject("contact", newContact);
        return modelAndView;
    }

    @PostMapping("contact/add")
    public String addAContactToUser(Principal principal,@ModelAttribute("contact") Contact contact ){
        userCredentialService.addContactToUser(principal.getName(), contact);
        return "redirect:/home";
    }

    @GetMapping("contact/add")
    public String addAContactToUser(Principal principal ){

        return "contactAdding";
    }

    @GetMapping("contact/delete/{id}")
    public String deleteContact( @PathVariable(value = "id") int id , Principal principal) throws Exception {
        userCredentialService.deleteContactOfUser(principal.getName(), id);
        return "redirect:/home";
    }
}
