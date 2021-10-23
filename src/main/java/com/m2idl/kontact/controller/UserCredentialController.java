package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.ContactService;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public ModelAndView listContacts(Principal principal){
        System.out.println("current user : "+principal.getName());
        List<Contact> contacts = userCredentialService.getContactsOfUser(principal.getName());
        ModelAndView modelAndView = new ModelAndView("contactsList");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @GetMapping("/contact/edit/{id}")
    public String getContactEdit(@PathVariable(value = "id") int id , Model model){
        Contact contact = contactService.getContact(id);
        model.addAttribute("contact", contact);
        return "contactEdit" ;
    }

    @PostMapping("/contact/edit/{id}")
    public String putContactEdit(@PathVariable(value = "id") int id,@Valid @ModelAttribute("contact") Contact contact, BindingResult errors, Model model, Principal principal) throws Exception {

        if(errors.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.contact", errors);
            model.addAttribute("contact", contact);
            return "redirect:/contact/edit/"+id;
        }
        userCredentialService.updateContactToUser(principal.getName(), contact, id);
        return "redirect:/home";
    }

    @PostMapping("contact/add")
    public String addAContactToUser(Principal principal, @Valid @ModelAttribute("contact") Contact contact, BindingResult errors, Model model ){
        if(errors.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.contact", errors);
            model.addAttribute("contact", contact);
            return "contactAdding";
        }
        userCredentialService.addContactToUser(principal.getName(), contact);
        return "redirect:/home";
    }

    @GetMapping("contact/add")
    public String addAContactToUser(){
        return "contactAdding";
    }

    @GetMapping("contact/delete/{id}")
    public String deleteContact( @PathVariable(value = "id") int id , Principal principal) throws Exception {
        userCredentialService.deleteContactOfUser(principal.getName(), id);
        return "redirect:/home";
    }
}
