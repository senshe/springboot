package com.rimitech.sgr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rimitech.sgr.dao.SuiviRepository;
import com.rimitech.sgr.dao.UsersRepository;
import com.rimitech.sgr.dao.VehicleRepository;
import com.rimitech.sgr.dto.SuiviDto;
import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Suivi;
import com.rimitech.sgr.models.Vehicle;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Component
public class SuiviServiceImpl implements SuiviService {
	
	@Autowired
	SuiviRepository suivis;
	@Autowired
	VehicleRepository vehicles;
	
	@Override
	public List<Suivi> findByNum(String num) {
		// TODO Auto-generated method stub
		return suivis.findByMatricule_Num_Num(num);
	}
	@Override
	public Suivi create(SuiviDto dto) {
		
		Vehicle v=vehicles.findByNum_Num(dto.getExpediteur());
		
		Suivi s= new Suivi();
		s.setAltitude(dto.getAltitude());
		s.setDateTime(new Date(dto.getDateTime()));
		s.setDescr(dto.getDescr());
		s.setEta(dto.getEta());
		s.setMatricule(v);
		s.setPosistion(wktToGeometry("POINT("+dto.getLon()+" "+dto.getLat()+")"));
		s.setVitess(dto.getVitess());
		return suivis.save(s);
	}
	
	public Geometry wktToGeometry(String wktString) {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(wktString);
            geom.setSRID(4326);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + wktString);
        }
        return geom;
    }
	
	@Override
	public List<Suivi> findAll() {
		// TODO Auto-generated method stub
		return suivis.findAll();
	}
	@Override
	public Suivi findLastPosistionByNum(String num) {
		// TODO Auto-generated method stub
		return suivis.findFirstByMatricule_Num_NumOrderByDateTimeDesc(num);
	}
	@Override
	public Suivi findLastPosistionByMatricule(String matricule) {
		Suivi	s=suivis.findFirstByMatricule_MatriculeOrderByDateTimeDesc(matricule);
		if(s==null){
			s=new Suivi();
			//s.setPosistion(posistion);
		}
		return s;
	}
	
	@Override
	public List<Suivi> findLastPosistions(Structure structure) {
		
		List<Vehicle> vs=vehicles.findByNum_Structure(structure);
		List<Suivi> suivislist=new ArrayList<Suivi>();
		
		for (Vehicle v:vs) {suivislist.add(suivis.findFirstByMatricule_MatriculeOrderByDateTimeDesc(v.getMatricule()));}
	
		return suivislist;
	}

	
}
