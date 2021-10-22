package com.m2idl.kontact;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import com.m2idl.kontact.service.ContactService;
import com.m2idl.kontact.service.UserCredentialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KontactApplication {

	public static void main(String[] args) {
		SpringApplication.run(KontactApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(UserCredentialService userCredentialService, ContactService contactService){
		return args -> {
			UserCredential userCredential = new UserCredential();
			userCredential.setEmail("test@test.fr");
			userCredential.setPassword("test");
			userCredentialService.addUser(userCredential);

			for(int index = 0 ; index < 10 ; index++){
				Contact contact = new Contact();
				contact.setTelephone("111111111"+index);
				contact.setFirstName("firstName"+index);
				contact.setLastName("lastName"+index);
				userCredentialService.addContactToUser(userCredential.getEmail(), contact);
			}

		};
	}

}
