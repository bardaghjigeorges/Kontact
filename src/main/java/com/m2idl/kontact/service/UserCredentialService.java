package com.m2idl.kontact.service;
import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserCredentialService {

    UserCredential addUser(UserCredential userCredential);

    Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password);

    UserCredential getUserByEmailAndPassword (String mail, String password);

    void addContactToUser(String mail, Contact contact);

    boolean userExistsByEmail(String email);

    UserCredential getUserByEmail(String email);

    List<Contact> getContactsOfUser(String email);

}
