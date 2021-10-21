package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class UserCredentialServiceImp implements UserCredentialService {

    @Autowired
    UserCredentialRepository userCredentialRepository;
    @Autowired
    ContactService contactService ;
    @Autowired
    PasswordEncoder passwordEncoder ;

    public UserCredential addUser(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential);
        return userCredential;
    }


    public Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password) {
        Optional<UserCredential> u = userCredentialRepository.findUserCredentialByEmailAndPassword(email, password);
        return u;
    }


    public UserCredential getUserByEmailAndPassword(String mail, String password) {
        return userCredentialRepository.getUserCredentialByEmailAndPassword(mail, password);
    }

    @Transactional
    public void addContactToUser(String mail, Contact contact){
       UserCredential user= userCredentialRepository.getUserCredentialByEmail(mail);
       user.getContacts().add(contact);
       userCredentialRepository.save(user);

}

    @Override
    public boolean userExistsByEmail(String email) {
        return userCredentialRepository.existsUserCredentialByEmail(email);
    }

    @Override
    public UserCredential getUserByEmail(String email) {
        return userCredentialRepository.getUserCredentialByEmail(email);
    }

    @Override
    @Transactional
    public List<Contact> getContactsOfUser(String email) {
        UserCredential u = userCredentialRepository.getUserCredentialByEmail(email);
        u.getContacts();
        return u.getContacts();
    }

}
