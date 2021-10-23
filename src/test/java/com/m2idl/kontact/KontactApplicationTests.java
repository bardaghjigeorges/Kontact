package com.m2idl.kontact;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.service.ContactServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class KontactApplicationTests {

	@Autowired
	ContactServiceImp contactServiceImp;

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







}
