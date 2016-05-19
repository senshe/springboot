package com.rimitech.sgr.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.EquipementRepository;
import com.rimitech.sgr.dao.VehicleRepository;
import com.rimitech.sgr.models.Equipement;
import com.rimitech.sgr.models.Vehicle;
@Component
public class VehicleServiceImpl implements VehicleService {
@Autowired
VehicleRepository vehicles;

@Autowired
EquipementRepository equipements;

	@Override
	public Vehicle add(Vehicle vehicle,String idequipement) {
		Equipement eq=equipements.findOne(idequipement);
		if(eq==null){
			
		}
		vehicle.setDateCreation(new Date());
		eq.setEta("ACTIVE");
		vehicle.setNum(eq);
		return vehicles.save(vehicle);
	}

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return vehicles.findAll();
	}

	@Override
	public Vehicle findOne(String id) {
		// TODO Auto-generated method stub
		return vehicles.findOne(id);
	}

	@Override
	public Vehicle findByNumero(String id) {
		// TODO Auto-generated method stub
		return vehicles.findByNum_Num(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
