package com.rimitech.sgr.services;

import java.util.List;

import com.rimitech.sgr.dto.SuiviDto;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Suivi;

public interface SuiviService {
	
List<Suivi> findByNum(String num);

Suivi create(SuiviDto dto);

List<Suivi> findAll();
Suivi findLastPosistionByNum(String num);
Suivi findLastPosistionByMatricule(String matricule);
List<Suivi> findLastPosistions(Structure structure);
}
