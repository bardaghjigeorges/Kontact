package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;

import java.util.Optional;

public interface ContactService {

    Contact addContact(Contact contact);

    Contact updateContact(Contact contact) throws Exception;

    void deleteContact(Contact contact);
}
