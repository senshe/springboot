package com.rimitech.sgr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Structure;



public interface EquipementRepository extends JpaRepository<Equipement, String> {
	List<Equipement> findByStructureAndEta(Structure stucture,String eta);
}
