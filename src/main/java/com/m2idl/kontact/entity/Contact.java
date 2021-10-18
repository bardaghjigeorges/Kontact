package com.m2idl.kontact.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    int id;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^$|[0-9]{10})")
    String telephone;

}
