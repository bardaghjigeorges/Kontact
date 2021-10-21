package com.m2idl.kontact.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
public class UserCredential {
    @Id
    String mail;

    @NotBlank()
    String password;

    @OneToMany
    List<Contact> contacts;

}
