package com.rimitech.sgr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Vehicle;



public interface VehicleRepository  extends JpaRepository<Vehicle, String> {
	Vehicle findByNum_Num(String num);
	List<Vehicle> findByNum_Structure(Structure structure);
}
