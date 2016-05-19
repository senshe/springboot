package com.rimitech.sgr.services;

import java.util.List;

import com.rimitech.sgr.models.Vehicle;


public interface VehicleService {
Vehicle add(Vehicle vehicle,String idequipement);
List<Vehicle> findAll();
Vehicle findOne(String id);
Vehicle findByNumero(String id);
void delete(Long id);
}
