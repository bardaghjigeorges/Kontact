package com.m2idl.kontact.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class UserCredential {
    @Id
    String mail;

    @NotBlank()
    String password;

    @OneToMany(mappedBy="user")
    List<Contact> contacts;

}
