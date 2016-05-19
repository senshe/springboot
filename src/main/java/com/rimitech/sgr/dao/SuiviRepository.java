package com.rimitech.sgr.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimitech.sgr.models.Suivi;


public interface SuiviRepository extends JpaRepository<Suivi, Long> {
	public List<Suivi> findByMatricule_Num_Num(String num);
	public Suivi findFirstByMatricule_Num_NumOrderByDateTimeDesc(String num);
	public Suivi findFirstByMatricule_MatriculeOrderByDateTimeDesc(String matricule);
	public List<Suivi> findByMatricule_MatriculeAndDateTimeBetweenOrderByDateTimeDesc(String matricule,Date departure, Date arrival );
	
}
