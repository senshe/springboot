package com.rimitech.sgr.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.RolesRepository;
import com.rimitech.sgr.dao.StructureRepository;
import com.rimitech.sgr.dao.UsersRepository;
import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Role;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersRepository users;
	@Autowired
	RolesRepository roles;
	@SuppressWarnings("unchecked")
	
	

	
	@Override
	public Users add(Users user, String code) {
		
		Role r=roles.findByCode(code);
		if(r==null)
		{
			
		}
		Collection<Role> roles =new HashSet();
		roles.add(r);
		user.setRoles(roles);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		users.save(user);
		return user;
	}
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return users.findAll();
	}
	@Override
	public Users update(Users user) {
		users.save(user);
		return user;
	}
	
	@Override
	public Users findOne(String nni) {
		
		return users.findOne(nni);
	}
	
	@Override
	public void delete(String nni) {
		// TODO Auto-generated method stub
		users.delete(nni);
	}
	@Override
	public Users addRoleToUser(Users user, String roleCode) {
		Role r=roles.findByCode(roleCode);
		if(r==null)
		{
			
		}
		
		user.getRoles().add(r);
		users.save(user);
		return user;
	}

	
	
	
	}
	


