package com.m2idl.kontact.repository;

import com.m2idl.kontact.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential, String> {

}
