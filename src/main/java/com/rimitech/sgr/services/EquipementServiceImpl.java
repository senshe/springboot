package com.rimitech.sgr.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.EquipementRepository;
import com.rimitech.sgr.dao.StructureRepository;
import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.security.Account;
import com.rimitech.sgr.services.*;

@Component
public class EquipementServiceImpl implements EquipementService{

	
	
	@Autowired
	EquipementRepository equipements;

	@Autowired
	StructureRepository structures;
	
	
	
	
	@Override
	public List<Equipement> findAll() {
		
		return equipements.findAll();
	}





	@Override
	public Equipement add(Equipement equipement, long idStructure) {
		
				Structure structure=structures.findOne(idStructure);
				if(structure==null){
					//validation
				}else{
					equipement.setStructure(structure);
					equipement.setEta("DISPO");
					equipement.setDateCreation(new Date());
					equipements.save(equipement);
				}
				
				return equipement;
	}





	@Override
	public Equipement update(Equipement equipement) {
		equipements.save(equipement);
		return equipement;
	}
	

	

	@Override
	public Equipement findOne(String num) {
		
		return equipements.findOne(num);
	}





	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		equipements.delete(id);
	}





	@Override
	public List<Equipement> findByEta(Structure stucture, String eta) {
	
		return equipements.findByStructureAndEta(stucture, eta);
	}



}
