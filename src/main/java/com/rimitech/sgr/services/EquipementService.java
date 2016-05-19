package com.rimitech.sgr.services;

import java.util.List;

import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Structure;

public interface EquipementService {
	
 Equipement add(Equipement equipement,long idStructure);
 Equipement update(Equipement equipement);
List<Equipement> findAll();
Equipement findOne(String num);
void delete(String id);
List<Equipement> findByEta(Structure stucture,String eta);
}
