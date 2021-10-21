package com.m2idl.kontact.repository;

import com.m2idl.kontact.entity.Contact;
import com.m2idl.kontact.entity.UserCredential;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {
 Optional<UserCredential> findUserCredentialByMailAndPassword(String mail, String password );
 UserCredential getUserCredentialByMailAndPassword(String mail , String password);
 Boolean existsUserCredentialByMail(String mail);
 UserCredential getUserCredentialByMail(String mail);

}
