package com.rimitech.sgr.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rimitech.sgr.dao.UsersRepository;
import com.rimitech.sgr.models.Role;
import com.rimitech.sgr.models.Users;



@Component
public class AccountDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDetailsService.class);
    @Autowired
    private  UsersRepository userService;
    
    @Override
    public Account loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        Users users = userService.getUserByEmail(email);
        		if(users==null){
        			throw  new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        		}
        		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            	
        for (Role authority : users.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getCode());
            grantedAuthorities.add(grantedAuthority);
        }
                
               
        return new Account(users,grantedAuthorities);
    }

}
