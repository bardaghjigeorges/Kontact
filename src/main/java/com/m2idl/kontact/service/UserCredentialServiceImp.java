package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.repository.UserCredentialRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class UserCredentialServiceImp implements UserCredentialService {

    @Autowired
    UserCredentialRepository ucr;


    public UserCredential addUser(UserCredential userCredential) {
        ucr.save(userCredential);
        return userCredential;
    }


    public Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password) {
        Optional<UserCredential> u = ucr.findUserCredentialByMailAndPassword(email, password);
        return u;
    }


    public UserCredential getUserByEmailAndPassword(String mail, String password) {
        return ucr.getUserCredentialByMailAndPassword(mail, password);
    }

    @Transactional
    public void addContactToUser(String mail, Contact contact){
       UserCredential user= ucr.getUserCredentialByMail(mail);
       user.getContacts().add(contact);
       ucr.save(user);

}

    @java.lang.Override
    public boolean userExistsByEmail(String email) {
        return ucr.existsUserCredentialByMail(email);
    }

    @java.lang.Override
    public List<Contact> getContactsOfUser(String email) {
        UserCredential u = ucr.getUserCredentialByMail(email);
        return u.getContacts();
    }

    @java.lang.Override
    public void deleteContactOfUser(String email, Contact contact) {
        UserCredential user= ucr.getUserCredentialByMail(email);
        List<Contact> list = user.getContacts();
        list.stream().filter(contact::equals).forEach(list::remove);

    }
}
