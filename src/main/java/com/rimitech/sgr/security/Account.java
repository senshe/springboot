package com.rimitech.sgr.security;



import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import com.rimitech.sgr.models.Role;
import com.rimitech.sgr.models.Users;

public class Account extends org.springframework.security.core.userdetails.User {

    private Users users;
    
    public Account(Users users,Collection<GrantedAuthority> grantedAuthorities) {
    	
        super(users.getEmail(), users.getPassword(),grantedAuthorities);
        this.users = users;
    }

    public Users getUser() {
        return users;
    }

    public String getNni() {
        return users.getNni();
    }

    public Collection<Role> getRole() {
        return users.getRoles();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + users +
                "} " + super.toString();
    }
}
