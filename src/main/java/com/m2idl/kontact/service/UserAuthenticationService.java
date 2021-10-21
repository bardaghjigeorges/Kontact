package com.m2idl.kontact.service;

import com.m2idl.kontact.entity.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    UserCredentialService userCredentialService ;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        try{

            UserCredential user = userCredentialService.getUserByEmail(mail);
            return new User(user.getMail(), user.getPassword(), new ArrayList<>());
        } catch (Exception e ){
            throw new UsernameNotFoundException("User : "+mail+" not found");
        }
    }
}
