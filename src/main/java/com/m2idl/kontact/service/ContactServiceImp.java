package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImp implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }


    public Contact updateContact(Contact newContact, int id) throws Exception {
        if (!contactRepository.existsContactById(id)){
           throw new Exception();
        }
        Contact contact = contactRepository.getById(id);
        contact.setFirstName(newContact.getFirstName());
        contact.setLastName(newContact.getLastName());
        contact.setTelephone(newContact.getTelephone());
       return  contactRepository.save(contact);

    }

    @Override
    public Contact getContact(int id) {
        return contactRepository.getById(id);
    }

    @Override
    @Transactional
    public void deleteContact(int id ) {
        Contact contact = getContact(id);
        contactRepository.delete(contact);
    }
}
