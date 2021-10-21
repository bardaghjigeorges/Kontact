package com.m2idl.kontact.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(telephone, contact.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, telephone);
    }
}
