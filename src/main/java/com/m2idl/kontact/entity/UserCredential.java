package com.m2idl.kontact.entity;

import lombok.Getter;


import lombok.NoArgsConstructor;

import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor

public class UserCredential {
    @Id
    String mail;

    @NotBlank()
    String password;

    @OneToMany(mappedBy="user")
    List<Contact> contacts = new ArrayList<>();

}
