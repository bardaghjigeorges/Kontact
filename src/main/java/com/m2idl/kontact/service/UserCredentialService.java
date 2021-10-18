package com.m2idl.kontact.service;
import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserCredentialService {

    UserCredential addUser(UserCredential userCredential);

    Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password);

    UserCredential getUserByEmailAndPassword (String mail, String password);

    void addContactToUser(UserCredential user, Contact contact);

    boolean userExistsByEmail(String email);

    List<Contact> getContactsOfUser(String email);

    void deleteContact(UserCredential user, Contact contact);

}
