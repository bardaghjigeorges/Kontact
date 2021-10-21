package com.m2idl.kontact.controller;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
        // utilisation de l'interface userCredentialService
        Optional<UserCredential> userCredential = userCredentialService.findOptionalUserByEmailAndPassword(email, password);
        // Mettre la valeur de l'utilsateur recuperé dans un attribut model pour pouvoir l'affiché après dans la view
        model.addAttribute( "nom_du_model_dans_la_vue", userCredential);
        return "view";
    }

    @RequestMapping("/index/user/{email}/{password}")
    public String findUser(@PathVariable String email, @PathVariable String password, Model model){
        // utilisation de l'interface userCredentialService
        UserCredential userCredential = userCredentialService.getUserByEmailAndPassword(email, password);
        // Mettre la valeur de l'utilsateur recuperé dans un attribut model pour pouvoir l'affiché après dans la view
        model.addAttribute("nom_du_model_dans_la_vue", userCredential);
        return "view";
    }

    @RequestMapping("indes/user/contact")
    public String addAContactToUser(UserCredential userCredential, Contact contact, Model model){
        //ajouter un contact à un user avec la userServiceCrednetial on ne renvoie pas de model on ajoute juste
        userCredentialService.addContactToUser(userCredential, contact);
        return "View";
    }

    @RequestMapping("/index/user/{email}")
    public boolean verifyUserByEmail(@PathVariable String email){
        //on verifie via la pathVariable que l'itilisateur existe bien
        if(userCredentialService.userExistsByEmail(email))
             return true;
        return false;
    }

    @RequestMapping("/indes/user/contact/{email}")
    public String getAllContactsOfUser (@PathVariable String email, Model model){
        //je stock tous les contacts dans une list
        List<Contact> allContacts = userCredentialService.getContactsOfUser(email);
        //j'ajoute une model attribute qui contient tous les contacts
        model.addAttribute("ListContacts", allContacts);
        return "view";
    }



}
