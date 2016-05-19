package com.rimitech.sgr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.EquipementRepository;
import com.rimitech.sgr.dao.RolesRepository;
import com.rimitech.sgr.models.Role;


@Component
public class RoleServiceImpl  implements RoleService{

	
	@Autowired
	RolesRepository roles;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roles.findAll();
	}

}
