package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImp implements ContactService {
        @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public Contact updateContact(Contact contact) throws Exception {
        if (!contactRepository.existsContactById(contact.getId())){
           throw new Exception();
        }
       return  contactRepository.save(contact);

    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
