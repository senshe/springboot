package com.rimitech.sgr.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.RolesRepository;
import com.rimitech.sgr.dao.StructureRepository;
import com.rimitech.sgr.models.Role;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;

@Component
public class StructureServiceImpl implements StructureService{

	
	
	private EntityManager em;
	@Autowired
	UsersServiceImpl users;
	@Autowired
	StructureRepository structures;
	
	@SuppressWarnings("unchecked")
	@Override
	public Structure add(Structure structure, Users admin) {
		admin.setPassword("admins");
		structure.setType("S");
	//	admin.setRoles(roles);
		structures.save(structure);
		admin.setStructure(structure);
		users.add(admin, "ADMINS");
		return structure;
	}
	
	@Override
	public List<Structure> findAll() {
		
		return structures.findByType("S");
	}

	@Override
	public Structure findOne(Long id) {
		
		return structures.findOne(id);
	}

	@Override
	public Users finAdmin(Long idSructure) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Structure update(Structure structure) {
		structures.save(structure);
		return structure;
	}

//
	@Override
	public void delete(Long id) {
		
		structures.delete(id);

	
	}
	


}
