package com.m2idl.kontact.repository;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {
 Optional<UserCredential> findUserCredentialByEmailAndPassword(String mail, String password );
 UserCredential getUserCredentialByEmailAndPassword(String mail , String password);
 Boolean existsUserCredentialByEmail(String mail);
 UserCredential getUserCredentialByEmail(String mail);

}
