package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.UserCredentialService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserCredentialController {

    @Autowired
    UserCredentialService userCredentialService;

    @PostMapping("/index/addUser")
    public UserCredential addNewUser(UserCredential userCredential, Model model){
        userCredentialService.addUser(userCredential);
        model.addAttribute( "no,m_du_model_dans_la_vue", userCredential);
        return userCredential;
    }

    @GetMapping("/index/user/{email}/{password}")
    public Optional<UserCredential> findUserOptional(@PathVariable String email, @PathVariable String password, Model model ){
        // utilisation de l'interface userCredentialService
        Optional<UserCredential> userCredential = userCredentialService.findOptionalUserByEmailAndPassword(email, password);
        // Mettre la valeur de l'utilsateur recuperé dans un attribut model pour pouvoir l'affiché après dans la view
        model.addAttribute( "nom_du_model_dans_la_vue", userCredential);
        return userCredential;
    }

    @GetMapping("/index/user/{email}/{password}")
    public UserCredential findUser(@PathVariable String email, @PathVariable String password, Model model){
        // utilisation de l'interface userCredentialService
        UserCredential userCredential = userCredentialService.getUserByEmailAndPassword(email, password);
        // Mettre la valeur de l'utilsateur recuperé dans un attribut model pour pouvoir l'affiché après dans la view
        model.addAttribute("nom_du_model_dans_la_vue", userCredential);
        return userCredential;
    }

    @PostMapping("indes/user/contact")
    public void addAContactToUser(UserCredential userCredential, Contact contact, Model model){
        //ajouter un contact à un user avec la userServiceCrednetial on ne renvoie pas de model on ajoute juste
        userCredentialService.addContactToUser(userCredential, contact);
    }

    @GetMapping("/index/user/{email}")
    public boolean verifyUserByEmail(@PathVariable String email){
        //on verifie via la pathVariable que l'itilisateur existe bien
        if(userCredentialService.userExistsByEmail(email))
             return true;
        return false;
    }

    @GetMapping("/index/user/contact/{email}")
    public List<Contact> getAllContactsOfUser (@PathVariable String email, Model model){
        //je stock tous les contacts dans une list
        List<Contact> allContacts = userCredentialService.getContactsOfUser(email);
        //j'ajoute une model attribute qui contient tous les contacts
        model.addAttribute("ListContacts", allContacts);
        return allContacts;
    }

    @DeleteMapping("/index/user/contact/{id}")
    public void deleteContact(UserCredential userCredential, Contact contact){
        userCredentialService.deleteContact(userCredential, contact);
    }




}
