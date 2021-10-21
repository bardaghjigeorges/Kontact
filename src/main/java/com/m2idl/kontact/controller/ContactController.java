package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/index/user/contact")
    public Contact addContact(Contact contact){
        //ajout d'un contact avec la service contactService
        return contactService.addContact(contact);
    }

    @PutMapping("/index/user/contact")
    public Contact updateContact(Contact contact){
        //il faut recupérer l'id du contact mais la fonction de la service elle ne prend pas d'id don je laisse ca à voir après
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/index/user/contact")
    public void deleteContact(Contact contact){
        //pareil ici il faut recupérer l'id du contact
        contactService.deleteContact(contact);
    }

}
