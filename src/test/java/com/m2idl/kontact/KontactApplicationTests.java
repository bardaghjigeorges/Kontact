package com.m2idl.kontact;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.ContactServiceImp;
import com.m2idl.kontact.service.UserCredentialServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;
import org.springframework.security.acls.model.AlreadyExistsException;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class KontactApplicationTests {

	@Autowired
	ContactServiceImp contactServiceImp;
	@Autowired
	UserCredentialServiceImp userCredentialServiceImp;

	@Test
	@Transactional
	void testAddContact() {
		Contact contact = new Contact();
		contact.setFirstName("salem");
		contact.setLastName("salem");
		contact.setTelephone("111111");
		contact.setId(4);
		contactServiceImp.addContact(contact);

		Contact expected=contactServiceImp.getContact(4);
		assertEquals(expected, contact);
	}

	@Test
	@Transactional
	void testUpdateContact() throws Exception {
		Contact contact = contactServiceImp.getContact(4);
		contact.setLastName("doub");
		contactServiceImp.updateContact(contact,4);
		assertEquals(contact.getLastName(),"doub");
	}


	@Test
	@Transactional
	void testGetContact(){
		Contact contact= contactServiceImp.getContact(4);
		assertEquals(contact.getFirstName(),"firstName3");
	}


	@Test
	@Transactional
	void addUser() throws AlreadyExistsException {
		UserCredential userCredential= new UserCredential();
		userCredential.setPassword("111");
		userCredential.setEmail("salem@salem.com");

		userCredentialServiceImp.addUser(userCredential);
		assertEquals(userCredentialServiceImp.getUserByEmail("salem@salem.com").getEmail(),"salem@salem.com");
	}

	@Test
	@Transactional
	void testUserExistsByEmail() throws AlreadyExistsException {
		UserCredential userCredential= new UserCredential();
		userCredential.setPassword("222");
		userCredential.setEmail("doub@doub.com");

		userCredentialServiceImp.addUser(userCredential);
		assertEquals(userCredentialServiceImp.userExistsByEmail("doub@doub.com"),true);

	}

	@Test
	@Transactional
	void testGetUserByEmail() throws AlreadyExistsException {
		UserCredential userCredential= new UserCredential();
		userCredential.setPassword("222");
		userCredential.setEmail("gounin@gounin.com");
		userCredentialServiceImp.addUser(userCredential);
		assertEquals(userCredentialServiceImp.getUserByEmail("gounin@gounin.com").getEmail(),"gounin@gounin.com");
	}

	@Test
	@Transactional
	void testGetContactsOfUser(){
		List<Contact> listContacts=userCredentialServiceImp.getContactsOfUser("test@test.fr");

		assertEquals(listContacts.isEmpty(),false);
	}




}
