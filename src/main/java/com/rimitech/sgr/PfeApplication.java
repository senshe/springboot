package com.rimitech.sgr;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rimitech.sgr.dao.RolesRepository;
import com.rimitech.sgr.dao.UsersRepository;
import com.rimitech.sgr.models.Role;
import com.rimitech.sgr.models.Users;

@SpringBootApplication

public class PfeApplication {

	public static void main(String[] args) {
		ApplicationContext contex=SpringApplication.run(PfeApplication.class, args);
		RolesRepository roles=contex.getBean(RolesRepository.class);
		if(roles.findByCode("ADMINS")==null){
			
			Role admins=new Role();
			Role admind=new Role();
			Role user=new Role();
			
			admins.setCode("ADMINS");
			admins.setLabel("admin structure");
			admind.setCode("ADMIND");
			admind.setLabel("admin direction");
			user.setCode("USER");
			user.setLabel("role de l'utilisateur");
			
			roles.save(admins);
			roles.save(admind);
			roles.save(user);
			Collection<Role> rr =new HashSet();
			Users u=new Users();
			UsersRepository users=contex.getBean(UsersRepository.class);
			u.setEmail("bastamiebou@gmail.com");
			u.setNni("110222304");
			u.setUsername("El Bastami");
			u.setPassword(new BCryptPasswordEncoder().encode("admin"));
		
			
			rr.add(user);
			rr.add(admind);
			rr.add(admins);
			u.setRoles(rr);
			users.save(u);
			
		}
	}
}
