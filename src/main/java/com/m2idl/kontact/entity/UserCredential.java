package com.m2idl.kontact.entity;

import lombok.Getter;


import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class UserCredential {
    @Id
    String email;

    @NotBlank()
    String password;

    @OneToMany(cascade = CascadeType.ALL)
    List<Contact> contacts = new ArrayList<>();

}
