package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.AlreadyExistsException;
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

    public UserCredential addUser(UserCredential userCredential) throws AlreadyExistsException {
        if(userExistsByEmail(userCredential.getEmail())) {
            throw new AlreadyExistsException("l'utilisateur existe deja.");
        }
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential);
        return userCredential;
    }

    @Override
    public UserCredential updateUser(UserCredential userCredential) throws Exception {
        if(! userExistsByEmail(userCredential.getEmail())){
            throw new Exception();
        }
        return userCredentialRepository.save(userCredential);
    }


    public Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password) {
        return userCredentialRepository.findUserCredentialByEmailAndPassword(email, password);
    }


    public UserCredential getUserByEmailAndPassword(String mail, String password) {
        return userCredentialRepository.getUserCredentialByEmailAndPassword(mail, password);
    }

    @Transactional
    public void addContactToUser(String mail, Contact contact){
        if(! userContainsContact(mail, contact)){
            UserCredential user= userCredentialRepository.getUserCredentialByEmail(mail);
            user.getContacts().add(contact);
            userCredentialRepository.save(user);
        }

}

    @Override
    public void updateContactToUser(String mail, Contact contact, int id) throws Exception {
        if(!userContainsContact(mail, contact)){
            contactService.updateContact(contact, id);
        }
    }

    @Override
    @Transactional
    public boolean userContainsContact(String email, Contact contact) {
        UserCredential userCredential = getUserByEmail(email);
        return userCredential.getContacts().stream().anyMatch(contact::equals);
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
        return u.getContacts();
    }

    @Override
    @Transactional
    public void deleteContactOfUser(String email, int idContact) throws Exception {
        UserCredential userCredential = getUserByEmail(email);
        Contact contact = userCredential.getContacts().stream().filter(c -> c.getId() == idContact ).findFirst().orElseThrow(Exception::new);
        userCredential.getContacts().remove(contact);
        updateUser(userCredential);
    }

}
