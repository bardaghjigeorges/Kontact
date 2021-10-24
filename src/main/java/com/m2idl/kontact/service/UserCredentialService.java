package com.m2idl.kontact.service;
import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserCredentialService {

    UserCredential addUser(UserCredential userCredential) throws Exception;

    UserCredential updateUser(UserCredential userCredential) throws Exception;

    Optional<UserCredential> findOptionalUserByEmailAndPassword(String email, String password);

    UserCredential getUserByEmailAndPassword (String mail, String password);

    void addContactToUser(String mail, Contact contact);

    void updateContactToUser(String mail, Contact contact, int id ) throws Exception;

    boolean userContainsContact(String email, Contact contact);

    boolean userExistsByEmail(String email);

    UserCredential getUserByEmail(String email);

    List<Contact> getContactsOfUser(String email);

    void deleteContactOfUser(String email, int idContact) throws Exception;

}
