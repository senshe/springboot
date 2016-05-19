package com.rimitech.sgr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;


public interface StructureRepository extends JpaRepository<Structure, Long> {
	
	// @Query(value="From Users u join u.roles r where r.code='ADMINS'  AND u.sructure.id=?" )
	// Users getUserByEmail(Long  idStructure,String  codeRole);
List<Structure> findByType(String type);
}
